package src;
import database.DatabaseCRM;
import src.ds.*;
import java.sql.SQLException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Product implements Comparable<Product> {
    private String category;
    private String name;
    private String ID;
    private Queue<String> comments; //PriorityQueue has been used.

    public Product(String name , String ID , String category) throws SQLException {
        this.name = name;
        this.ID = ID;
        this.category = category;
        comments = new PriorityQueue<>();
        DatabaseCRM.connectDB();
    }

    public String getCategory(){return category;};
    public String getName(){return name;};
    public String getID() {
        return ID;
    }
    public void updateProduct(String name) throws SQLException {
        this.name = name;
        DatabaseCRM.ProductsDB.updateProductName(this.ID,name);
    }

    public void addComment(String comment) throws Exception {
        if(comment.length() == 0) throw new Exception("Comment cannot be an empty text!");
        comments.add(comment);
        DatabaseCRM.ProductsDB.addCommentDB(this.ID,comment);
        System.out.println("Comment has been added!");
    }

    @Override
    public int compareTo(Product o) {
        if(this.ID.compareTo(o.ID) == 0) return 0;
        else if(this.ID.compareTo(o.ID) > 0) return 1;
        else return -1;
    }
}
