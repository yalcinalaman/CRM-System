import java.util.Queue;

public class Customer extends User{
    private String email;
    private String phoneNumber;
    private Queue<String> message;

    public String getEmail(){return email;}
    public String getPhoneNumber(){return  phoneNumber;}

    // public void setEmail(String email){}
    // public void setPhoneNumber(String phoneNumber){}

    // public void addCommentProduct(Product product){}
    // public void sendMessage(){}
    // public void getMessage(){}

    // public boolean findProduct(int ID){return true;}
}
