package validations;

public class EmailValidator{
    public static boolean validate(String email) {

        int atCount = 0;
        int dotCount = 0;
        int atPosition = -1;
        for(int i = 0 ; i <email.length() ; i++)
        {
            char c = email.charAt(i);
            if(c == '@')
            {
                atCount++;
                atPosition = i;
            }
            else if (c == '.' && atPosition != -1)
            {
                dotCount++;
            }
            if(atCount == 1 && dotCount == 1 && atPosition > 0 && atPosition < email.length() - 4 )
            {
                return true;
            }

        }
        return false;
    
    }
}

