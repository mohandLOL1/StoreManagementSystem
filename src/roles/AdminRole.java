package roles;
import databases.EmployeeUserDatabase;
import users.EmployeeUser;

import java.io.IOException;

public class AdminRole {

    private EmployeeUserDatabase database = new EmployeeUserDatabase("data/Employees.txt") ;
    public AdminRole(){

    }

public  void addEmployee(String employeeId,String name,String email,String address, String phoneNumder) throws IOException {

     int test =Integer.parseInt(employeeId.trim());
     if(test>=0){
    EmployeeUser record=new EmployeeUser(employeeId,name,email,address,phoneNumder);
    database.insertRecord(record);
    this.logout();}
     else {
         System.out.println("coudn't save record, negative id !!");
     }
}



public  EmployeeUser[] getListOfEmployees(){
        EmployeeUser[] ListEmployeeUser=database.returnAllRecords().toArray(new EmployeeUser[0]);
        return ListEmployeeUser;

    }




    public void removeEmployee(String key){
        database.deleteRecord(key);
        this.logout();
    }




    public void logout(){

        try {
            database.saveToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
