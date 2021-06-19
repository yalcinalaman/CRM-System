package database;

import src.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCRM {
    static Connection connection;

    private static final String DATABASE_URL = "jdbc:mysql://remotemysql.com:3306/cecvsYhcHb";
    private static final String USERNAME = "cecvsYhcHb";
    private static final String PASSWORD = "M8UDYowfD8";

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
    public static class UserDB {

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

        public static List<Admin> getAllUserFromDB() throws SQLException {
            String query = "SELECT * FROM users";
            List<Admin> admins = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String id = result.getString(1);
                String password = result.getString(2);
                String name = result.getString(3);
                String surname = result.getString(4);
                String email = result.getString(5);
                String phone = result.getString(6);

                if(id.charAt(0) ==  'A')
                    admins.add(new Admin(name,surname,id,password));
                /*else if(id.charAt(0) == 'B')
                    admins.add(new BusinessDeveloper(name,surname,id,password));
                else if(id.charAt(0) == 'C')
                    admins.add(new Customer(name,surname,id,password,email,phone));*/
                else
                    System.out.println("Undefined customer id in database");
            }
            return admins;

        }

    }
    /**
     * ScheduleDB class for database CRUD operations of schedule.
     */
    public static class ScheduleDB {

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
    public static class MessagesDB{
        public static void readAllCustomerMessage(User user) throws SQLException{

            String query = "SELECT * FROM messages WHERE customer_id = " + user.getID();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            String message;

            System.out.println(user.getName() + " messages");
            while(resultSet.next()){
                message = resultSet.getString(2);
                System.out.println(message);
            }
        }
    }
    public static class ProductsDB{
        static class ProductDB{
            private String productId;
            private String productName;
            private String category;
            private ArrayList<String> comments;

            public ProductDB(String id,String name,String category,ArrayList<String> comments) {
                this.productId = id;
                this.productName = name;
                this.category = category;
                this.comments = comments;
            }
            public String getProductId() {
                return this.productId;
            }
            public String getProductName() {
                return this.productName;
            }
            public String getCategory() {
                return this.category;
            }
            public ArrayList<String> getComments(){
                return this.comments;
            }
            public String toString() {
                String txt = "";
                txt+=("product id \t: "+this.productId);
                txt+=("\nproduct name \t: "+this.productName);
                txt+=("\nproduct category: "+this.category);
                txt+=("\ncomments \t: "+this.comments);
                return txt;
            }
        }
        public static Connection connectDB() {

            String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11418313";
            String userName = "sql11418313";
            String password = "J2u5Bx3j8B";
            try {
                Connection connection = DriverManager.getConnection(url,userName,password);
                return connection;

            } catch (SQLException e) {
                return null;
            }
        }
        public static ProductDB getProductFromDB(String productId) throws SQLException {
            Connection  connection = connectDB();
            ProductDB product = null;
            if(connection!=null) {
                PreparedStatement statement = connection.prepareStatement("select * from sql11418313.products where products.productId = ?");
                statement.setString(1, productId);
                ResultSet res = statement.executeQuery();
                while(res.next()) {
                    product = new ProductDB(res.getString("productId"), res.getString("productName"), res.getString("category"), getCommentbyProdIdDB(productId));
                }
            }
            return product;
        }
        public static ArrayList<String> getAllProductId() throws SQLException{
            ArrayList<String > list = new ArrayList<>();
            Connection connection = connectDB();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement("SELECT productId FROM sql11418313.products;");
                ResultSet res = statement.executeQuery();
                while(res.next()) {
                    list.add(res.getString("productId"));
                }
            }
            return list;
        }

        public static boolean updateProductName(String productId,String newName) throws SQLException {
            Connection connection = connectDB();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement("UPDATE sql11418313.products set productName = ? WHERE productId = ?");
                statement.setString(1, newName);
                statement.setString(2, productId);
                int res =statement.executeUpdate();
                if(res > 0 )
                    return true;
            }
            return false;
        }

        public static boolean addCommentDB(String productId,String comment) throws SQLException {
            Connection connection = connectDB();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO sql11418313.comments values(default,?,?);");
                statement.setString(1,productId );
                statement.setString(2,comment);
                int res = statement.executeUpdate();
                if(res > 0) return true;
            }
            return false;
        }

        public static ArrayList<String> getCommentbyProdIdDB(String prodId) throws SQLException {
            Connection connection = connectDB();
            if( connection != null) {
                ArrayList<String> list = new ArrayList<>();
                PreparedStatement statement = connection
                        .prepareStatement("SELECT * FROM sql11418313.comments where comments.productId = ?;");
                statement.setString(1, prodId);
                ResultSet res = statement.executeQuery();
                while(res.next()) {
                    list.add(res.getString("comment"));
                }
                return list;
            }
            return null;
        }
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
