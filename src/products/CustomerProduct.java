package products;

import databases.Searchable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProduct implements Searchable {
    private String customerSSN, productID;
    private LocalDate purchaseDate;
    private boolean paid;
    
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate, boolean paid)
    {
    this.customerSSN = customerSSN;
    this.productID = productID;
    setLocalDate(purchaseDate);
    this.paid = paid;
    }

    public String getCustomerSSN()
     {
         return this.customerSSN;
     }

     public String getProductID()
     {
         return this.productID;
     }
     public LocalDate getPurchaseDate()
     {
         return this.purchaseDate;
     }

     private void setLocalDate(LocalDate localDate) {
        if(LocalDate.now().isBefore(localDate)){
            System.out.println("Cannot set purchase date in the future, setting it to current day");
            this.purchaseDate = LocalDate.now();
        }
        else{
            this.purchaseDate = localDate;
         }
     }

     public String lineRepresentation()
     {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         return customerSSN + "," + productID + "," + purchaseDate.format(formatter) + "," + paid;
     }

     public boolean isPaid()
     {
         return this.paid;
     }

     public void setPaid(boolean paid)
     {
         this.paid = paid;
     }

     public String getSearchKey()
     {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         return customerSSN + "," + productID + "," + purchaseDate.format(formatter);
     }
}
