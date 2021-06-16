package database;

import src.*;

import java.sql.*;

public class DatabaseCRM {
    static Connection connection;

    private static final String DATABASE_URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11418313";
    private static final String USERNAME = "sql11418313";
    private static final String PASSWORD = "J2u5Bx3j8B";

    public static void main(String[] args) throws SQLException {
        connectDB();
        // UserDB.readAllUserFromDB();
    }

    public static void connectDB() throws SQLException {

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Connected properly.");
        } catch (Exception e) {
            assert e instanceof SQLException;
            printSQLException((SQLException) e);
        }

    }

    /**
     * UserDB class for database CRUD operations of user.
     */
    static class UserDB {

        /**
         * Reads all user from database table
         *
         * @throws SQLException throws a SQLException
         */
        public static void readAllUserFromDB() throws SQLException {
            String sql = "SELECT * FROM users";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int userCount = 0;

            System.out.println("All users from Database ->");
            while (result.next()) {
                String id = result.getString(1);
                String password = result.getString(2);
                String name = result.getString(3);
                String surname = result.getString(4);

                String output = "%d : %s - %s - %s - %s";

                System.out.printf((output) + "%n", ++userCount, id, password, name, surname);
            }
        }

        public static void readAllAdminsFromDB() throws SQLException {
            String sql = "SELECT * FROM users WHERE id LIKE 'A%'";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int userCount = 0;

            System.out.println("\n\nAll ADMINS from Database ->");
            while (result.next()) {
                String id = result.getString(1);
                String password = result.getString(2);
                String name = result.getString(3);
                String surname = result.getString(4);

                String output = "%d : %s - %s - %s - %s";

                System.out.printf((output) + "%n", ++userCount, id, password, name, surname);
            }
        }

        /**
         * Read a specific User from database
         *
         * @param userID ID of the user
         * @return return a User object
         * @throws SQLException throws a SQLException
         */
        public static User readUserFromDB(String userID) throws SQLException {

            String sql = " SELECT * FROM users where id ='" + userID + "'";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            String id, password, name, surname;

            User userReaded = null;
            while (result.next()) {
                id = result.getString(1);
                password = result.getString(2);
                name = result.getString(3);
                surname = result.getString(4);
                String output = "%s - %s - %s - %s";
                // System.out.printf((output) + "%n", id, password, name, surname);
                userReaded = new User(name, surname, id, password);
            }
            return userReaded;
        }

        /**
         * Delete a user from database
         *
         * @param userID ID of the user
         * @throws SQLException throws a SQLException
         */
        public static void deleteUserFromDB(String userID) throws SQLException {
            String sql = "DELETE FROM users WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userID);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
        }

        /**
         * create a user in database
         *
         * @param user created user object
         * @throws SQLException throws a SQLException
         */
        public static void createUserInDB(User user) throws SQLException {

            if (hasExistUser(user.getID())) {
                System.err.println("This ID: " + user.getID() + " has exist in Database.");
                return;
            }

            String sql = "INSERT INTO users (id, password, name, surname) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getID());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurName());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

        }

        /**
         * update the user data at database
         *
         * @param user updated user object
         * @throws SQLException throws a SQLException
         */
        public static void updateUserInDB(User user) throws SQLException {
            String sql = "UPDATE users SET password=?, name=?, surname=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(4, user.getID());
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getName());
            statement.setString(3, user.getSurName());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
        }

        /**
         * check a user exist in database
         *
         * @param id id of the user to check existing
         * @return tru or false as a result of ResultSet
         * @throws SQLException throws a SQLException
         */
        public static boolean hasExistUser(String id) throws SQLException {
            String sql = "Select 1 from users where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }

    }

    /**
     * ScheduleDB class for database CRUD operations of schedule.
     */
    static class ScheduleDB {

        /**
         * Reads all schedules from database table
         *
         * @throws SQLException throws a SQLException
         */
        public static void readAllScheduleFromDB() throws SQLException {
            String sql = "SELECT * FROM schedule";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String date = String.valueOf(result.getDate(1));
                String process = result.getString(2);

                String output = "%s - %s";
                System.out.println("All schedules from Database -> ");
                System.out.printf((output) + "%n", date, process);
            }
        }

        public static Schedule readScheduleFromDB(String process) throws SQLException {

            String sql = " SELECT * FROM schedule where process ='" + process + "'";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Date date;

            Schedule readed = null;
            while (result.next()) {
                date = result.getDate(1);
                process = result.getString(2);
                String output = "%s - %s";
                readed = new Schedule(date, process);
            }
            return readed;
        }

        /**
         * Delete a schedule from database
         *
         * @param process process of the schedule date
         * @throws SQLException throws a SQLException
         */
        public static void deleteScheduleFromDB(String process) throws SQLException {
            String sql = "DELETE FROM schedule WHERE process=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, process);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A process was deleted successfully!");
            }
        }

        /**
         * create a schedule in database
         *
         * @param schedule created schedule object
         * @throws SQLException throws a SQLException
         */
        public static void createScheduleInDB(Schedule schedule) throws SQLException {

            String sql = "INSERT INTO schedule (date, process) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, (Date) schedule.getDate());
            statement.setString(2, schedule.getProcess());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Schedule was created successfully!");
            }

        }

        /**
         * update the schedule data at database
         *
         * @param schedule updated schedule object
         * @throws SQLException throws a SQLException
         */
        public static void updateScheduleInDB(Schedule schedule) throws SQLException {
            String sql = "UPDATE schedule SET date=?, process=? WHERE process=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, (Date) schedule.getDate());
            statement.setString(2, schedule.getProcess());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing schedule was updated successfully!");
            }
        }

    }

    public static boolean hasExist(String TableName, String ColumnName, String value) throws SQLException {
        String selectSql = "SELECT CASE WHEN EXISTS (SELECT TOP 1 * FROM " + TableName + " WHERE " + ColumnName + "= '"
                + value + "') THEN CAST (1 AS BIT) ELSE CAST (0 AS BIT) END";
        String hasExist = " SELECT EXISTS (SELECT * FROM " + TableName + " WHERE " + ColumnName + "='" + value + "');";
        Statement statement = (Statement) connection.createStatement();
        ResultSet resultSet = statement.executeQuery(hasExist);
        return resultSet.next();
    }

    /**
     * A custom exception method for SQL errors
     *
     * @param ex SQLException
     */
    private static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
