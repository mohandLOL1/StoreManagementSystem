import databases.EmployeeUserDatabase;
import databases.ProductDatabase;
import users.EmployeeUser;
import products.Product;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class run {

   public static void main(String[] args) throws IOException {
        EmployeeUser e1 = new EmployeeUser("5","2","3","4","5");
        EmployeeUserDatabase db = new EmployeeUserDatabase("Employees.txt");

        ProductDatabase pdb = new ProductDatabase("Products.txt");
        Product p1 = new Product("1","2","3","4",10, 1000.0F);
        db.readFromFile();
        db.insertRecord(e1);
        db.saveToFile();

        LocalDate date = LocalDate.of(2025,2,24);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String d = date.format(formatter);
       System.out.println(d); 
        pdb.insertRecord(p1);
        pdb.saveToFile();
    }
}
