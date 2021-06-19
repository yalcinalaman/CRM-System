package src;

public class TestDriver {

    public static void main(String[] args) {
        try {
            CRMSystem crmSystem = new CRMSystem("Mobilyacı");
        }
        catch (Exception exception){
            System.err.println(exception.getMessage());
        }
    }
}