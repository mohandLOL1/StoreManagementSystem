package validations;
import java.io.*;

public class NameValidator {
public static boolean validate(String Name){

  if(Name==null)
      return false;
     
  char[]name=Name.toCharArray();
     
  for(int i=0;i<Name.length();i++){
     if(!Character.isLetter(name[i]))
         System.out.println("name bad");
        return false;}
  
     return true;
}
}
