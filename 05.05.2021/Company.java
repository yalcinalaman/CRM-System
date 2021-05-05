
import java.util.List;
import java.util.Queue;

public class Company {
    private String companyName;

    private List<User> admin;
    private List<User> businessDev;
    private List<User> customer;
    private BinarySearchTree<Product> products;
    private Queue<UserInformationSystem> uis;

    public Company(String companyName){this.companyName = companyName;}

    public void showAllAdmins(){}
    public void showAllBusinessDev(){}
    public void showAllCustomers(){}


}
