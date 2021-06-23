package src;
import java.util.List;
import java.util.PriorityQueue;

public class BusinessDeveloper extends User {
    private PriorityQueue<Schedule> schedules;
    public BusinessDeveloper(String name, String surName, String ID, String password) {
        super(name, surName, ID, password);
    }

    public void manageOffering(){}
    public boolean addProduct(Product product){return true;}
    public Product removeProduct(Product product){return null;}
    public void setCustomerName(String userID, String name){}
    public void setCustomerSurName(String userID, String surName){}
    public void setCustomerEmail(String userID, String email){}
    public void setCustomerPhoneNumber(String userID, String phoneNumber){}
    public List<Customer> viewAllCustomers(){return null;}
    public void manageSchedule(){}
    public void addSchedule(){}
    public void removeSchedule(){}
    public boolean findProduct(String ID){return true;}

}
