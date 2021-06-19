package src;
import java.util.List;
import java.util.PriorityQueue;

public class BusinessDeveloper extends User{
    private PriorityQueue<Schedule> schedules;
    public BusinessDeveloper(String name, String surName, String ID, String password) {
        super(name, surName, ID, password);
    }

    public void manageOffering(){}
    public boolean addProduct(Product product){return true;}
    public Product removeProduct(Product product){return null;}
    public void setCustomerName(int userID, String name){}
    public void setCustomerSurName(int userID, String surName){}
    public void setCustomerEmail(int userID, String email){}
    public void setCustomerPhoneNumber(int userID, String phoneNumber){}
    public List<Customer> viewAllCustomers(){return null;}
    public void manageSchedule(){}
    public void addSchedule(){}
    public void removeSchedule(){}
    public boolean findProduct(int ID){return true;}

}
