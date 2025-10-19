
package validations;
public class PhoneValidator {
    public static boolean validate(String number) {

        if (number.trim().length() != 12) return false;
        else {
            char[] char_number = number.toCharArray();
            for (char c : char_number) {
                if(c == '+') continue;
                if (!Character.isDigit(c)) return false;
            }
        }
        return true;
    }
}
