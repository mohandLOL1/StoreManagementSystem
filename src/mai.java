import databases.EmployeeUserDatabase;
import roles.AdminRole;
import users.EmployeeUser;

import java.io.IOException;

public class mai {

   public static void main(String[] args) throws IOException {

       AdminRole a1=new AdminRole();

       a1.addEmployee("  -1","lola","lola","jfff","efefef");

         EmployeeUser[] array=a1.getListOfEmployees();
       System.out.println(array[0].lineRepresentation());
       /*AdminRole aa=new AdminRole();
       aa.removeEmployee("5");
     */

    }
}
