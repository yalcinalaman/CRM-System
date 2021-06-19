package database;

import src.*;

import java.sql.SQLException;

public class DatabaseCRM_TEST {

    public static void main(String[] args) throws SQLException {

        User usin55 = new User("denem", "user", "Asdf", "pass");
        // User C1 = new User("customer1", "Alper", "C1", "ua55");


        DatabaseCRM.connectDB();

        //DatabaseCRM.UserDB.deleteUserFromDB("C1");
        DatabaseCRM.UserDB.createUserInDB(usin55);
        DatabaseCRM.UserDB.readAllUserFromDB();
        DatabaseCRM.UserDB.readAllAdminsFromDB();

        System.out.println("\n");


    }
}
