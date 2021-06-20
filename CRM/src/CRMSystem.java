package src;

import java.sql.SQLException;

public class CRMSystem{
    /*Bu objeyi (company) kullanarak kullanıcılara, ürünlere erişebilirsiniz. Bu class bi nevi driver olacak.
     * User kendi yazacağı mainde bu classın objesini oluşturacak. Bütün işlemler bu class üzerinden gerçekleşecek.
     * */
    Company company;

    public CRMSystem(String company_name) throws SQLException, ClassNotFoundException {
        company = new Company(company_name);
    }

    public User login(String userID){

        return null;
    }
    private void showMenu(User user){}
    private void adminMenu(){}
    private void developerMenu(){}
    private void customerMenu(){}
    public boolean singUp(String name, String surName, String email, String phoneNumber){
        return true;
    }

}