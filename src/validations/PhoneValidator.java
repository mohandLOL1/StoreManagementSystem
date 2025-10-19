
package validations;
public class PhoneValidator {
    public static boolean validate(String number) {

        if (number.trim().length() != 11) return false;
        else {
            char[] char_number = number.toCharArray();
            for (char c : char_number) {
                if (!Character.isDigit(c)) return false;
            }
        }
        return true;
    }
}
