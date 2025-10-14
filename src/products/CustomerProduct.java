package products;

public class CustomerProduct {
    private String customerSSN, productID;
    private LocalDate  purchaseDate;
    private boolean paid;
    
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate, boolean paid)
    {
    this.customerSSN = customerSSN;
    this.productID = productID;
    this.purchaseDate = purchaseDate;
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
     public String lineRepresentation()
     {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
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
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
         return customerSSN + "," + productID + "," + purchaseDate.format(formatter);
     }
}
