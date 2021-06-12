package src;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Customer extends User implements Comparable<Customer> {
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

    /***
     * Customer can add a comment to a product by using this method. It throws an exception if the product is null and comment is empty string
     * @param product
     * @param comment
     * @throws Exception
     */
    public void addCommentProduct(Product product , String comment) throws Exception {
        if(product == null) throw new NoSuchElementException("Product does not exist.");
        product.addComment(comment);
    }

    /***
     * Customer can send message to the seller by using this method. The msg will be added into the private field of the Customer
     * @param msg
     * @throws Exception
     */
    public void sendMessage(String msg) throws Exception {
        if(msg.length() == 0) throw new Exception("Message cannot be an empty string");
        message.add(msg);
        System.out.println("Message has been sent. The seller is going to respond it within 48 days.");
    }

    /***
     * Returns the private field which is "message"
     * @return Returns the private field which is "message"
     */
    public Queue<String> getMessage() {
        return message;
    }

    /**
     * Burada bir adet BinarySearchTree almalı. Diğer türlü eğer company classını extend edersem constructor çağırdığında güncelde bululan Company
     * objesi kullanılmayacak. Bu classları Company veya CRMSystem içerisinden çağırırız diye products alabilecek şekilde bıraktım.
     */
    //TODO: BinarySearchTree için iterator lazım.
    /*public boolean findProduct(BinarySearchTree<Product> products, int ID) {
    }*/


    /***
     * Compares two customers values by their names
     * @param o
     * @return 0 when names are equal, 1 when the calling customer's name is higher. Returns -1 otherwise.
     */
    @Override
    public int compareTo(Customer o) {
        if(this.getName().compareTo(o.getName()) == 0) return 0;
        else if(this.getName().compareTo(o.getName()) > 0) return 1;
        else return -1;
    }
}
