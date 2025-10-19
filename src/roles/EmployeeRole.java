
package roles;

import databases.CustomerProductDatabase;
import databases.ProductDatabase;
import databases.Searchable;
import products.CustomerProduct;
import products.Product;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class EmployeeRole {
 private final ProductDatabase productsDatabase;
 private final CustomerProductDatabase customerProductDatabase;
 
 public EmployeeRole() throws IOException {

    productsDatabase = new ProductDatabase("data/Products.txt");
    customerProductDatabase = new CustomerProductDatabase("data/CustomerProducts.txt");
    productsDatabase.readFromFile();
    customerProductDatabase.readFromFile();
 }

public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) throws IOException {
 Product addProduct=new Product(productID , productName ,manufacturerName ,supplierName,quantity,price);
 productsDatabase.insertRecord(addProduct);
 productsDatabase.saveToFile();
 }
 
public Product[] getListOfProducts(){
     return productsDatabase.returnAllRecords().toArray(new Product[0]);
 }
public CustomerProduct[] getListOfPurchasingOperations(){
     return customerProductDatabase.returnAllRecords().toArray(new CustomerProduct[0]);
 } 
 
public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) throws IOException {
  Product product = (Product) productsDatabase.getRecord(productID);

  if(product == null) {
      System.out.println("Cannot purchase null product");
      return false;
  }

  if(product.getQuantity()<=0) {
      System.out.println("Product is out of stock, cannot purchase");
      return false;
  }

  product.setQuantity(product.getQuantity()-1);

  CustomerProduct purchaseProduct=new CustomerProduct(customerSSN,productID,purchaseDate,true);

  customerProductDatabase.insertRecord(purchaseProduct);
  productsDatabase.saveToFile();
  customerProductDatabase.saveToFile();
  return true;
}
 
public double returnProduct(String customerSSN, String productID,LocalDate purchaseDate ,LocalDate returnDate) throws IOException {

     if(returnDate.isBefore(purchaseDate))
       return -1;

   String line= new CustomerProduct(customerSSN,productID,purchaseDate,true).getSearchKey();

   if(!customerProductDatabase.contains(line))
      return -1;

   Product product = (Product) productsDatabase.getRecord(productID);
   if(product == null)
     return -1;

   long difference=ChronoUnit.DAYS.between(purchaseDate,returnDate);

    if(difference > 14)
       return -1;

   product.setQuantity(product.getQuantity()+1);
   customerProductDatabase.deleteRecord(line);
   customerProductDatabase.saveToFile();
   productsDatabase.saveToFile();

   return product.getPrice();
  }

public boolean applyPayment(String customerSSN, LocalDate purchaseDate) throws IOException {
 
  ArrayList<Searchable> list= customerProductDatabase.returnAllRecords();

    for (Searchable searchable : list) {

        CustomerProduct apply = (CustomerProduct) searchable;
        if (customerSSN.equals(apply.getCustomerSSN()) && purchaseDate.equals(apply.getPurchaseDate())) {
            if (!apply.isPaid())
            {
                apply.setPaid(true);
                customerProductDatabase.saveToFile();
                return true;
            }
            else
            {
                System.out.println("Product is already paid for");
                return false;
            }
        }
    }

    System.out.println("Couldn't find product");
    return false;
 }

public void logout() throws IOException {
  productsDatabase.saveToFile();
  customerProductDatabase.saveToFile();
 }
}
 


