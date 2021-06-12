package database;
import src.Schedule;
import src.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DatabaseCRM_TEST {
    public static void main(String[] args) throws SQLException {
        User admin55 = new User("Umut", "Alper", "A55", "ua55");
        User C1 = new User("customer1", "Alper", "C1", "ua55");

        //TODO: Please create a user to check methods..

        DatabaseCRM.connectDB();

        //DatabaseCRM.UserDB.deleteUserFromDB("C1");
        DatabaseCRM.UserDB.createUserInDB(C1);
        DatabaseCRM.UserDB.readAllUserFromDB();
        DatabaseCRM.UserDB.readAllAdminsFromDB();


        System.out.println("\n");
/*
        Date date = Date.valueOf(LocalDate.now());
        Schedule sc = new Schedule(date, "process1");
        //DatabaseCRM.ScheduleDB.createScheduleInDB(sc);
        DatabaseCRM.ScheduleDB.readAllScheduleFromDB();
        /* FOLLOWING IS FOR CHECKING THE EXISTING METHOD THEREFORE SYS.ERR */
        //System.err.println(DatabaseCRM.ScheduleDB.hasExist("schedule", "process", "process1"));

    }
}
