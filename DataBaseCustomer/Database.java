import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.xdevapi.Statement;
// import com.mysql.jdbc.Connection;

public class Database{


    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private static final String MAX_POOL = "250"; // set your own limit

    // init connection object
    private Connection connection = null;
    // init properties object
    private Properties properties = null;

    public Database(){

    }

    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private Properties getProperties() {

        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    public static boolean addCustomer(Customer c){
        
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Customers VALUES ");

        sb.append("(");
        sb.append(c.getID());
        sb.append(c.getName());
        sb.append(c.getSurName());
        sb.append(c.getEmail());
        sb.append(c.getPassword());
        sb.append(c.getPhoneNumber());
        sb.append(");");

        return false;
    }
    
    public static Customer removeCustomer(Customer c){
    
        StringBuilder sb = new StringBuilder();
        
        sb.append("DELETE FROM Customers WHERE ");
        sb.append(c.getEmail() + "=" + c.getEmail());
    
        return null;
    
    }

    public static void main(String[] args){

        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = (ResultSet) statement.execute();

            while(resultSet.next()){
                System.out.println(resultSet.getString(0));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
