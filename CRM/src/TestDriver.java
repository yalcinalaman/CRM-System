package src;

public class TestDriver {

    public static void main(String[] args) {
        try {
            CRMSystem crmSystem = new CRMSystem("Mobilyacı");

            //TC_01
            crmSystem.company.showAllAdmins();
            System.out.println("TC_01 - Verify that Admin login page is works with valid ID and password.");
            crmSystem.company.login("A3","123");

            //TC_02
            crmSystem.company.showAllBusinessDev();
            System.out.println("TC_02 - Verify that Business Developer login page is works with valid ID and password.");
            crmSystem.company.login("B1","123");

            //TC_03
            crmSystem.company.showAllCustomers();
            System.out.println("TC_03 - Verify that Customer login page is works with valid ID and password.");
            crmSystem.company.login("C2","123");

            //TC_04
            System.out.println("TC_04 - Verify that login page is works with valid ID and invalid password.");
            crmSystem.company.login("C2","invalid");

            //TC_05
            System.out.println("TC_05 - Verify that login page is works with invalid ID and valid password.");
            crmSystem.company.login("invalid","valid");

            //TC_06
            System.out.println("TC_06 - Verify that login page is works with invalid ID and invalid password.");
            crmSystem.company.login("invalid","invalid");

            //TC_07 Canceled
            //TC_08 Canceled
            //TC_09 Canceled
            //TC_10 Canceled

            //TC_11
            System.out.println("TC_11 - Verify that Customer can create an account.");
            crmSystem.company.signUp(new Customer("Anthony","Gale","C15","ASD"));

            //TC_12
            System.out.println("TC_12 - Verify that BD or Admin can create account for Customer.");
            Admin admin = new Admin("admin","admin","A12","admin");
            Customer customer = new Customer("Dan","Cron","C23","dan123");
            admin.addCustomer(customer);

            //TC_13 Canceled
            //TC_14 Canceled
            //TC_15 Canceled

            //TC_16
            System.out.println("TC_16 - Verify that Admin can remove Customer from the system.");
            admin.removeCustomer("C23");

            //TC_17
            System.out.println("TC_17 - Verify that Admin can add Business Developer.");
            admin.addBusinessDev(new BusinessDeveloper("Betty","Green","B12","betty123"));

            //TC_18 Canceled

            //TC_19
            System.out.println("TC_19 - Verify that Admin can remove Business Developer from the system.");
            admin.removeBusinessDev("B12");

            //TC_20
            System.out.println("TC_20 - Verify that Admin / BD can add product to the system.");
            admin.addProduct(new Product("Oak Table","P555","Tables"));
        }
        catch (Exception exception){
            System.err.println(exception.getMessage());
        }
    }
}