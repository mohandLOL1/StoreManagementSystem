package databases;

import java.util.ArrayList;

public abstract class DataBase<T> {  //makes abstract class that will be used as a blueprint for inheritance
  private String filename;
  private ArrayList<T> record;

    public DataBase(String filename) {
        this.filename = filename; //need to check for file's existence, can be implemented later
        this.record = new ArrayList<>();
    }

    public String getFilename() {
        return filename;
    }

    public abstract void readFromFile();
    public abstract T createRecordFrom(String line);
    public abstract ArrayList<T> returnAllRecord();
    public abstract boolean contains(String key);
    public abstract T getRecord(String key);
    public abstract void insertRecord(T record);
    public abstract void deleteRecord(String key);
    public abstract void saveToFile();
}
