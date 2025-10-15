import databases.EmployeeUserDatabase;
import databases.ProductDatabase;
import users.EmployeeUser;
import products.Product;
import java.io.IOException;

public class mai {

   public static void main(String[] args) throws IOException {
        EmployeeUser e1 = new EmployeeUser("5","2","3","4","5");
        EmployeeUserDatabase db = new EmployeeUserDatabase("Employees.txt");

        ProductDatabase pdb = new ProductDatabase("Products.txt");
        Product p1 = new Product("1","2","3","4",10, 1000.0F);
        db.readFromFile();
        db.insertRecord(e1);
        db.saveToFile();

        pdb.readFromFile();
        pdb.insertRecord(p1);
        pdb.saveToFile();
    }
}
