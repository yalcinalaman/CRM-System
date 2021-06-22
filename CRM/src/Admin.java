package src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Admin extends User{
    private PriorityQueue<Schedule> schedules;

    public Admin(String name, String surName, String ID, String password) {
        super(name, surName, ID, password);
    }

    public boolean addBusinessDev(User user){
        if(user == null){
            System.out.println("Invalid input!");
            return false;
        }
        if (user.getID().charAt(0) == 'B'){
            boolean hasExist = DatabaseCRM.UserDB.hasExistUser(user.getID());
            if (hasExist){
                System.out.println("This ID is already in use!");
                return false;
            }
            else {
                /* ******************* */
                DatabaseCRM.UserDB.createCustomerInDB(user);
                return true;
            }
        }
        else{
            System.out.println("Invalid user!");
            return false;
        }
    }

    /**
     * Adds a new customer to the system
     * @param user
     * @return
     */
    public boolean addCustomer(User user){
        if(user == null){
            System.out.println("Invalid input!");
            return false;
        }
        if (user.getID().charAt(0) == 'C'){
            boolean hasExist = DatabaseCRM.UserDB.hasExistUser(user.getID());
            if (hasExist){
                System.out.println("This ID is already in use!");
                return false;
            }
            else {
                DatabaseCRM.UserDB.createCustomerInDB(user);
                return true;
            }
        }
        else{
            System.out.println("Invalid user!");
            return false;
        }

    }
    

    /**
     * Removes the customer from the system
     * @param ID
     * @return
     */
    public boolean removeCustomer(String ID){
        if (ID == null){
            System.out.println("Invalid ID!");
            return false;
        }
        if (userID.charAt(0) == 'C'){
            Customer temp =  (Customer) DatabaseCRM.UserDB.readUserFromDB(userID);
            if (temp == null){
                System.out.println("Invalid ID!!");
                return false;
            }
            DatabaseCRM.UserDB.deleteUserFromDB(ID);
            return true;
        }
        else {
            System.out.println("Invalid ID!");
            return false;
        }
    }

    /**
     * Removes the business developer from the system
     * @param ID
     * @return
     */
    public boolean removeBusinessDev(String ID){
        if (ID == null){
            System.out.println("Invalid ID!");
            return false;
        }
        if (userID.charAt(0) == 'B'){
            BusinessDeveloper temp =  (BusinessDeveloper) DatabaseCRM.UserDB.readUserFromDB(userID);
            if (temp == null){
                System.out.println("Invalid ID!!");
                return false;
            }
            DatabaseCRM.UserDB.deleteUserFromDB(ID);
            return true;
        }
        else {
            System.out.println("Invalid ID!");
            return false;
        }
    }

    /**
     *
     * @param productId
     * @return
     */
    public boolean removeProduct(String productId){
        if (ID == null){
            System.out.println("Invalid ID!");
            return false;
        }
        Product temp = DatabaseCRM.ProductsDB.getProductFromDB(productId);
        if (temp == null){
            System.out.println("Product not found");
            return false;
        }
        DatabaseCRM.ProductsDB.deleteProductFromDB(productId);
        return true;
    }

    /**
     * Update the user's name
     * @param userID
     * @param name
     */
    public void setUserName(String userID, String name){
        if (name == null || userID == null){
            System.out.println("Invalid ID or name!");
            return;
        }
        User temp = DatabaseCRM.UserDB.readUserFromDB(userID);
        if (temp == null){
            System.out.println("Invalid ID!!");
            return;
        }
        temp.setName(name);
        DatabaseCRM.UserDB.updateUserInDB(temp);
    }

    /**
     * Update the user's surname
     * @param userID
     * @param surName
     */
    public void setUserSurName(String userID, String surName){
        if (surName == null || userID == null){
            System.out.println("Invalid ID or surname!");
            return;
        }
        User temp = DatabaseCRM.UserDB.readUserFromDB(userID);
        if (temp == null){
            System.out.println("Invalid ID!!");
            return;
        }
        temp.setSurName(surName);
        DatabaseCRM.UserDB.updateCustomerInDB(temp);
    }

    /**
     * Update the customer's email
     * @param userID
     * @param email
     */
    public void setCustomerEmail(String userID, String email){
        if (email == null || userID == null){
            System.out.println("Invalid ID or email!");
            return;
        }
        if (userID.charAt(0) == 'C'){
            Customer temp =  DatabaseCRM.UserDB.readCustomerFromDB(userID);
            if (temp == null){
                System.out.println("Invalid ID!!");
                return;
            }
            temp.setEmail(email);
            DatabaseCRM.UserDB.updateCustomerInDB(temp);
        }
        else {
            System.out.println("Invalid ID!");
            return;
        }
    }

    /**
     * Update the customer's phone number
     * @param userID
     * @param phoneNumber
     */
    public void setCustomerPhoneNumber(String userID, String phoneNumber){
        if (phoneNumber == null || userID == null){
            System.out.println("Invalid ID or email!");
            return;
        }
        if (userID.charAt(0) == 'C'){
            Customer temp = DatabaseCRM.UserDB.readCustomerFromDB(userID);
            if (temp == null){
                System.out.println("Invalid ID!!");
                return;
            }
            temp.setPhoneNumber(phoneNumber);
            DatabaseCRM.UserDB.updateUserInDB(temp);
        }
        else {
            System.out.println("Invalid ID!");
            return;
        }
    }

    /**
     * Prints all users in the system
     */
    public void viewAllUsers(){
        DatabaseCRM.UserDB.readAllUserFromDB();
    }

    /**
     * Prints and return all products in the system
     * @return all products in the system
     */
    public BinarySearchTree<Product> getAllProducts(){
        BinarySearchTree<Product> allProducts = DatabaseCRM.ProductsDB.getAllProductsFromDB();
        System.out.println(allProducts.toString());
        return allProducts;
    }

    /**
     * Search for the product specified in the system.
     * If the product exists in the system, it prints
     * the product's information and returns true otherwise return false.
     * @param productId
     * @return true if the product exists in the system otherwise return false.
     */
    public boolean findProduct(String productId){
        if (productId == null){
            System.out.println("Invalid productId!");
            return false;
        }
        Product temp = DatabaseCRM.ProductsDB.getProductFromDB(productId);
        if (temp == null){
            System.out.println("Product not found!");
            return false;
        }
        System.out.println(temp.toString());
        return true;
    }


    public boolean addProduct(Product product){}
    public void manageCustomersFeedBack(){}
    public void manageSchedule(){}
    public void addSchedule(){}
    public void removeSchedule(){}




}
