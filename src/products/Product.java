package products;

public class Product {
    private String productID, productName, manufacturerName,supplierName;
    private int quantity;
    private float price;
    
    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price)
    {
        this.productID = productID;
        this.manufacturerName = manufacturerName;
        this.price = price;
        this.productName = productName;
        this.quantity = quantity;
        this.supplierName = supplierName;
    }
    
    public int getQuantity()
    {
        return this.quantity;
    }
    public void setQuantity(int quantity)
    {
       this.quantity = quantity; 
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
