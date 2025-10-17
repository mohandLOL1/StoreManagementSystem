/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRole {
 private ProductDatabase productsDatabase;
 private CustomerProductDatabase customerProductDatabase;
 
 public EmployeeRole(){
    productsDatabase = new ProductDatabase("Products.txt");
    customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
    productsDatabase.readFromFile();
    customerProductDatabase.readFromFile();
 }

public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price){
 Product addProduct=new Product(productID , productName ,manufacturerName ,supplierName,quantity,price);
 productsDatabase.insertRecord(addProduct);
 productsDatabase.saveToFile();
 }
 
public Product[] getListOfProducts(){
 ArrayList<Product> list=productsDatabase.returnAllRecords();
  return list.toArray(new Product[0]);
 }
public CustomerProduct[] getListOfPurchasingOperations(){
 ArrayList<CustomerProduct> list=customerProductDatabase.returnAllRecords();
  return list.toArray(new CustomerProduct[0]);
 } 
 
public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate){
  Product product = productsDatabase.getRecord(productID);
  if(product ==null)
      return false;
  if(product.getQuantity()==0)
      return false;
  product.setQuantity(product.getQuantity()-1);
  CustomerProduct purchaseProduct=new CustomerProduct(customerSSN,productID,purchaseDate);
  customerProductDatabase.insertRecord(purchaseProduct);
  productsDatabase.saveToFile();
  customerProductDatabase.saveToFile();
       return true;
}
 
public double returnProduct(String customerSSN, String productID,LocalDate purchaseDate ,LocalDate returnDate){
   if(returnDate.isBefore(purchaseDate))
       return -1;
   DateTimeFormatter Date1=DateTimeFormatter.ofPattern("dd-MM-yyyy");
   String D=purchaseDate.format(Date1);
   String line=customerSSN + "," + productID + "," +D;
   if(!customerProductDatabase.contains(line)))
      return -1;
   Product product = productsDatabase.getRecord(productID);
   if(product ==null)
     return -1;
   long difference=ChronoUnit.DAYS.between(purchaseDate,returnDate);
    if(difference>14)
       return -1;
   product.setQuantity(product.getQuantity()+1);
   customerProductDatabase.deleteRecord(line);
   customerProductDatabase.saveToFile();
   productsDatabase.saveToFile();
   String[] lines= product.lineRepresentation().split(",");
   double price= Double.parseDouble(lines[5]);
   return price;
  }

public boolean applyPayment(String customerSSN, LocalDate purchaseDate){
  DateTimeFormatter Date1=DateTimeFormatter.ofPattern("dd-MM-yyyy");
  ArrayList<CustomerProduct> list=customerProductDatabase.returnAllRecords();
  for(int i=0;i<list.size();i++){
    CustomerProduct apply=list.get(i);
  if(customerSSN.equals(apply.getCustomerSSN())&&purchaseDate.equals(apply.getPurchaseDate())){
      if(!apply.isPaid()){
          apply.setPaid(true);
          customerProductDatabase.saveToFile();
          return true;
      }
      else
         return false;
  }}
  return false;
 }

public void logout()throws Exception{
 productsDatabase.saveToFile();            
 customerProductDatabase.saveToFile();
 }
}
 

