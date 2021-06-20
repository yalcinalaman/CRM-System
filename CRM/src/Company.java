package src;
import DataStructures.*;
import database.*;

import java.sql.SQLException;
import java.util.*;

public class Company extends DatabaseCRM {
    private String companyName;

    /*
    private List<Admin> admin;
    private List<BusinessDeveloper> businessDev;
    private SkipList<Customer> customer; //SkipList has been used here.
*/
    private List<Admin> admin;
    private List<BusinessDeveloper> businessDev;
    private SkipList<Customer> customer;

    private BinarySearchTree<Product> products;
    private Queue<String> messages;
    private Queue<UserInformationSystem> uis;

    public Company(String companyName) throws SQLException, ClassNotFoundException {
        DatabaseCRM.connectDB();
        admin = new ArrayList<>();
        businessDev = new ArrayList<>();
        customer = new SkipList<>();
        products = new BinarySearchTree<>();
        this.companyName = companyName;
        setFields();
        print();
    }

    //TODO remove this function
    private void print() {
        for (Admin value : admin) {
            System.out.println(value.getName());
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    /***
     * Prints all the admins
     */
    public void showAllAdmins() {
        System.out.println("\t*******ADMINS*******");
        System.out.println(String.format("%30s\t%30s\t%10s", "Name", "Surname", "ID"));
        ;
        for (Admin value : admin) {
            System.out.println(String.format("%30s\t%30s\t%10s", value.getName(),
                    value.getSurName(),
                    value.getID()));
        }
    }

    /***
     * Prints all the business developers
     */
    public void showAllBusinessDev() {
        System.out.println("\t*******BUSINESS DEVELOPERS*******");
        System.out.println(String.format("%30s\t%30s\t%10s", "Name", "Surname", "ID"));
        ;
        for (int i = 0; i < admin.size(); i++) {
            System.out.println(String.format("%30s\t%30s\t%10s", businessDev.get(i).getName(),
                    businessDev.get(i).getSurName(),
                    businessDev.get(i).getID()));
        }
    }

    /***
     * Prints all the customers
     */
    public void showAllCustomers() {
        System.out.println("\t*******CUSTOMERS*******");
        System.out.println(String.format("%30s\t%30s\t%10s\t%10s", "Name", "Surname", "ID", "Phone Number"));
        ;
        SkipList.SkipListIter iter = (SkipList.SkipListIter) customer.iterator();
        while (iter.hasNext()) {
            Customer temp = (Customer) iter.next();
            System.out.println(String.format("%30s\t%30s\t%10s\t%10s", temp.getName(), temp.getSurName(),
                    temp.getID(), temp.getPhoneNumber()));

        }
    }

    //TODO: Sadece admin için yapıyor. Bütün fieldlar için yap
    private void setFields() throws SQLException {
        admin = DatabaseCRM.UserDB.getAllAdminsFromDB();
        customer = DatabaseCRM.UserDB.getAllCustomersFromDB();
        businessDev = DatabaseCRM.UserDB.getAllDevelopersFromDB();
        //products = DatabaseCRM.ProductsDB.getAllProductsFromDB();

        //TODO: Databaseden alınan veriler Admin, businessDev, customer, products ve uis variablelarına atılacak.
    }

    public List<Admin> getAllAdmins() {
        return admin;
    }

    public BinarySearchTree<Product> getAllProducts() {
        return products;
    }

    public List<BusinessDeveloper> getAllBusinessDevs() {
        return businessDev;
    }

    public Queue<UserInformationSystem> getUis() {
        return uis;
    }

    public Queue<String> getMessages() {
        return messages;
    }

    public void setMessages(Queue<String> messages) {
        this.messages = messages;
    }

    public SkipList<Customer> getAllCustomers() {
        return customer;
    }

    /**
     * Returns the admin which has the given ID
     *
     * @param ID
     * @return Admin object with the given ID
     * @throws NoSuchElementException
     */
    public Admin getAdmin(String ID) throws NoSuchElementException {
        for (Admin value : admin) {
            if (value.getID().equals(ID)) return value;
        }
        throw new NoSuchElementException("There is no admin with the given ID");
    }

    /**
     * Returns the business developer which has the given ID
     *
     * @param ID
     * @return BusinessDev object with the given ID
     * @throws NoSuchElementException
     */
    public BusinessDeveloper getBusinessDev(String ID) throws NoSuchElementException {
        for (BusinessDeveloper businessDeveloper : businessDev) {
            if (businessDeveloper.getID().equals(ID)) return businessDeveloper;
        }
        throw new NoSuchElementException("There is no business developer with the given ID");
    }

    /**
     * Returns the customer which has the given ID
     *
     * @param ID
     * @return Customer object with the given ID
     * @throws NoSuchElementException
     */
    public Customer getCustomer(String ID) throws NoSuchElementException {
        SkipList.SkipListIter iter = (SkipList.SkipListIter) customer.iterator();
        while (iter.hasNext()) {
            Customer temp = (Customer) iter.next();
            if (temp.getID().equals(ID)) return temp;
        }
        throw new NoSuchElementException("There is no customer with the given ID");
    }
}