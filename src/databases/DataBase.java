package databases;



import java.nio.file.*;
import java.util.ArrayList;
import java.io.*;


public abstract class DataBase<T extends Searchable> {  //makes abstract class that will be used as a blueprint for inheritance

    private String filename;
    private final ArrayList<T> records;

    public DataBase(String filename) {
        this.setFilename(filename);
        this.records = new ArrayList<>();
    }

    public void setFilename(String filename) {
        Path path = Paths.get(filename);

        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File not found: " + path.toAbsolutePath());
        }

        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void readFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(getFilename()));
        String line;
        ArrayList<T> records = returnAllRecords();
        records.clear();
        while((line = reader.readLine()) != null){

            line = line.trim();
            if (line.isEmpty()) continue;
            records.add(createRecordFrom(line));
        }
        reader.close();
        System.out.println("Read from " + this.getFilename() + " Successfully, record size is " + records.size());
    }
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

    public void saveToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(getFilename()));

        ArrayList<T> records = returnAllRecords();

        for (T record : records) {
            writer.write(record.lineRepresentation() + "\n");
        }
        writer.close();

        System.out.println("Changes saved to file successfully");
    }
}
