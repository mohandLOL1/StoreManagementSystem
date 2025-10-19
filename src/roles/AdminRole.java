package roles;
import databases.EmployeeUserDatabase;
import users.EmployeeUser;
import validations.*;
import java.io.IOException;

public class AdminRole {

    private final EmployeeUserDatabase database;
    public AdminRole() throws IOException {
        this.database = new EmployeeUserDatabase("data/Employees.txt") ;
        this.database.readFromFile();
    }

public  void addEmployee(String employeeId,String name,String email,String address, String phoneNumber) throws IOException {
        if(validations.EmailValidator.validate(email)) {
            EmployeeUser record = new EmployeeUser(employeeId, name, email, address, phoneNumber);
            database.insertRecord(record);
        }
        else{
            System.out.println("Couldn't add employee, invalid credentials");
        }
}



    public  EmployeeUser[] getListOfEmployees(){
       return database.returnAllRecords().toArray(new EmployeeUser[0]);
    }

    public void removeEmployee(String key)
    {
        database.deleteRecord(key);
    }


    public void logout(){
        try {
            database.saveToFile();
            System.out.println("Data saved to file successfully!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
