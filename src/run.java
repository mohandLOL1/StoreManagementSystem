import databases.CustomerProductDatabase;
import databases.EmployeeUserDatabase;
import products.CustomerProduct;
import roles.AdminRole;
import roles.EmployeeRole;
import users.EmployeeUser;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class run {

    static void main(String[] args) throws IOException {
        EmployeeUser e1 = new EmployeeUser("5","2","3","4","5");
        EmployeeUserDatabase db = new EmployeeUserDatabase("data/Employees.txt");
        AdminRole a1 = new AdminRole();
        EmployeeRole x1 = new EmployeeRole();
        CustomerProduct c1 = new CustomerProduct("2121313","p12",LocalDate.of(2025,12,2),true);

        CustomerProductDatabase cdb = new CustomerProductDatabase("data/CustomerProducts.txt");
        cdb.insertRecord(c1);
        cdb.saveToFile();
        System.out.println(c1.getSearchKey());
    }
}
