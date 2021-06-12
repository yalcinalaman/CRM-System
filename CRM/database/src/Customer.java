package src;
import java.util.Queue;

public class Customer extends User {


    private String email;
    private String phoneNumber;
    private Queue<String> message;


    public Customer(String name, String surName, String ID, String password, String email, String phoneNumber) {
        super(name, surName, ID, password);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMessage(Queue<String> message) {
        this.message = message;
    }


    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void addCommentProduct(Product product) {
    }

    public void sendMessage() {
    }

    public void getMessage() {
    }

    public boolean findProduct(int ID) {
        return true;
    }
}
