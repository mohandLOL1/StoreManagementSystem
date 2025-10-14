package databases;

import products.CustomerProduct;

import java.util.ArrayList;

public class CustomerProductDatabase extends DataBase<CustomerProduct> {
    public CustomerProductDatabase(String filename) {
        super(filename);
    }

    @Override
    public void readFromFile() {

    }

    @Override
    public CustomerProduct createRecordFrom(String line) {
        return null;
    }


    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public CustomerProduct getRecord(String key) {
        return null;
    }

    @Override
    public void insertRecord(CustomerProduct record) {

    }

    @Override
    public void deleteRecord(String key) {

    }

    @Override
    public void saveToFile() {

    }
}
