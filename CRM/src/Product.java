package src;
import java.util.Queue;

public class Product implements Comparable<Product> {
    private String category;
    private String name;
    private String ID;
    private Queue<String> comments;

    public String getCategory(){return category;};
    public String getName(){return name;};

    public void addComment(String comment){}

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
