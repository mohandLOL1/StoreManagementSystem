import databases.EmployeeUserDatabase;
import users.EmployeeUser;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class run {

    static void main(String[] args) throws IOException {
        EmployeeUser e1 = new EmployeeUser("5","2","3","4","5");
        EmployeeUserDatabase db = new EmployeeUserDatabase("Employees.txt");

        db.readFromFile();
        db.insertRecord(e1);
        db.saveToFile();

    }
}
