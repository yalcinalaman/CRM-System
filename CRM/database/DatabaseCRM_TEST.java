package database;
import DataStructures.BinarySearchTree;
import DataStructures.SkipList;
import src.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DatabaseCRM_TEST {

    static List<Admin> adminList = new ArrayList<>();
    static SkipList<Customer> customerList = new SkipList<>();
    static List<BusinessDeveloper> businessDeveloperList = new ArrayList<>();
    static BinarySearchTree<Product> products = new BinarySearchTree<>();
    static Queue<UserInformationSystem> uis;

    static Queue<String> messages = new LinkedList<>();

    public static void main(String[] args) throws SQLException {


        DatabaseCRM.connectDB();
        adminList = DatabaseCRM.UserDB.getAllAdminsFromDB();
        customerList = DatabaseCRM.UserDB.getAllCustomersFromDB();
        businessDeveloperList = DatabaseCRM.UserDB.getAllDevelopersFromDB();


        System.out.println(adminList.get(0).getID());
        System.out.println(businessDeveloperList.get(0).getID());

        System.out.println();

        DatabaseCRM.MessagesDB.readAllCustomerMessage("C1");

        messages = DatabaseCRM.MessagesDB.getMessagesOfCustomerFromDB("C1");
        System.out.println("C1 Messages:" + messages);

        products = DatabaseCRM.ProductsDB.getAllProductsFromDB();


    }
}
