import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

public class Admin extends User{
    private PriorityQueue<Schedule> schedules;

    public boolean addCustomer(User user){return true;}
    public User removeCustomer(int ID){return null;}
    public boolean addBusinessDev(User user){return true;}
    public User removeBusinessDev(int ID){return null;}
    public boolean addProduct(Product product){return true;}
    public Product removeProduct(Product product){return null;}

    public void setUserName(int userID, String name){}
    public void setUserSurName(int userID, String surName){}
    public void setCustomerEmail(int userID, String email){}
    public void setCustomerPhoneNumber(int userID, String phoneNumber){}

    public List<Product> getAllProducts(){return new ArrayList<>();}
    public void viewAllUsers(){}
    public void manageCustomersFeedBack(){}

    public void manageSchedule(){}
    public void addSchedule(){}
    public void removeSchedule(){}

    public boolean findProduct(int ID){return true;}


}
