package databases;

import products.Product;

import java.io.*;


public class ProductDatabase extends  DataBase<Product> {
    public ProductDatabase(String filename) {
        super(filename);
    }

    @Override
    public Product createRecordFrom(String line) {
        String[] tokens = line.split(",");

        if (tokens.length != 6) {
            System.err.println("Malformed line (expected 6 tokens): " + line);
            return null;
        }

        String ID;
        String name;
        String manufacturer;
        String supplier;
        String quantity;
        String price;

        ID = tokens[0];
        name = tokens[1];
        manufacturer =tokens[2];
        quantity = tokens[3];
        supplier = tokens[4];
        price = tokens[5];

        return new Product(ID, name, manufacturer, supplier,Integer.parseInt(quantity), Float.parseFloat(price));
    }
    }





