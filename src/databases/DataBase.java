package databases;

import java.nio.file.*;
import java.util.ArrayList;
import java.io.*;


public abstract class DataBase<T extends Searchable> {  //makes abstract class that will be used as a blueprint for inheritance
    @SuppressWarnings("unused")
    private final String filename;
    @SuppressWarnings("unused")
    private ArrayList<T> records;

    public DataBase(String filename) {
        Path path = Paths.get( filename);

        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File not found: " + path.toAbsolutePath());
        }

        this.filename = filename;
        this.records = new ArrayList<>();
    }



    public String getFilename() {
        return filename;
    }

    public abstract void readFromFile() throws IOException;
    public abstract T createRecordFrom(String line);
    public ArrayList<T> returnAllRecords(){
        return this.records;
    }
    public boolean contains(String key){

        ArrayList<T> records = returnAllRecords();
        for(T record : records){
            if(record.getSearchKey().equals(key))
                return true;
        }
        return false;
    }
    public T getRecord(String key){
        ArrayList<T> records = returnAllRecords();
        for(T record : records){
            if(record.getSearchKey().equals(key)){
                return record;
            }
        }

        System.out.println("Couldn't find record, returning null");
        return null;
    }
    public void insertRecord(T record){
        ArrayList<T> records = returnAllRecords();
        if(!contains(record.getSearchKey())){
           records.add(record);
        }
        else{
            System.out.println("Couldn't add record, non-unique key");
        }

    }

    public void deleteRecord(String key){
        ArrayList<T> records = returnAllRecords();

        for(T record : records){
            if(record.getSearchKey().equals(key)){
                records.remove(record);
                System.out.println("Removed record from database");
                return;
            }
        }

        System.out.println("Couldn't find record, failed to remove");
    }
    @SuppressWarnings("unused")
    public abstract void saveToFile() throws IOException;
}
