package databases;

import products.Product;

import java.util.ArrayList;

public class ProductDatabase extends  DataBase<Product> {
    public ProductDatabase(String filename) {
        super(filename);
    }

    @Override
    public void readFromFile() {

    }

    @Override
    public Product createRecordFrom(String line) {
        return null;
    }


    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public Product getRecord(String key) {
        return null;
    }

    @Override
    public void insertRecord(Product record) {

    }

    @Override
    public void deleteRecord(String key) {

    }

    @Override
    public void saveToFile() {

    }
}
