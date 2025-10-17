package databases;

import products.CustomerProduct;
import java.time.LocalDate;


public class CustomerProductDatabase extends DataBase{
    public CustomerProductDatabase(String filename) {
        super(filename);
    }

    private static LocalDate stringToLocalDate(String date){
        String[] tokens = date.split("-");
        return LocalDate.of(Integer.parseInt(tokens[2]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[0]));
    }

    @Override
    public CustomerProduct createRecordFrom(String line) {
        String[] tokens = line.split(",");
        if (tokens.length != 4) {
            System.err.println("Malformed line (expected 4 tokens): " + line);
            return null;
        }

        String SSN;
        String productID;
        LocalDate date;
        String isPaid;

        SSN = tokens[0];
        productID= tokens[1];
        date  = stringToLocalDate(tokens[2]);
        isPaid = tokens[3];
        return new CustomerProduct(SSN,productID,date,Boolean.parseBoolean(isPaid));
    }

}
