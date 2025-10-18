package products;

import databases.Searchable;

public class Product implements Searchable {
    private String productID, productName, manufacturerName,supplierName;
    private int quantity;
    private float price;
    
    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price)
    {
        this.productID = productID;
        this.manufacturerName = manufacturerName;
        this.price = price;
        this.productName = productName;
        this.setQuantity(quantity);
        this.supplierName = supplierName;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity()
    {
        return this.quantity;
    }
    public void setQuantity(int quantity)
    {
        if(quantity >= 0)
          this.quantity = quantity;
        else{
            System.out.println("Invalid quantity, setting it to zero");
            this.quantity = 0;
        }
    }
    public String lineRepresentation()
    {
        return productID + "," + productName + "," + manufacturerName + "," + supplierName + "," + quantity + "," + price;
    }
    public String getSearchKey()
    {
        return this.productID;
    }
}
