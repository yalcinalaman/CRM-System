import java.sql.*;

public class Database{

    public Database(){

    }

    public static String addCustomer(Customer c){
        
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO user VALUES ");

        sb.append("(");
        sb.append("'" + c.getID() + "',");
        sb.append("'" + c.getName() + ",");
        sb.append("'" + c.getSurName() + ",");
        sb.append("'" + c.getPassword() + ",");
        sb.append("'" + c.getEmail() + ",");
        sb.append("'" + c.getPhoneNumber());
        sb.append(");");

        return sb.toString();
    }

    public static String removeCustomer(Customer c){
    
        StringBuilder sb = new StringBuilder();
        
        sb.append("DELETE FROM user WHERE ");
        sb.append("email" + "= '" + c.getEmail()+"'");
    
        return sb.toString();
    
    }


    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://192.168.1.172:3306/customer_user";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";


    public static void main(String[] args){

        try{

            Customer c = new Customer();
            Class.forName(DATABASE_DRIVER);
            
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            Statement statement = (Statement) connection.createStatement();

            String add = addCustomer(c);
            int resultSet =  statement.executeUpdate(add);
            System.out.println(resultSet);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
