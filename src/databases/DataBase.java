package databases;



import java.nio.file.*;
import java.util.ArrayList;
import java.io.*;


public abstract class DataBase{  //makes abstract class that will be used as a blueprint for inheritance

    private String filename;
    private final ArrayList<Searchable> records;

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
        ArrayList<Searchable> records = returnAllRecords();
        records.clear();
        while((line = reader.readLine()) != null){

            line = line.trim();
            if (line.isEmpty()) continue;
            records.add(createRecordFrom(line));
        }
        reader.close();
        System.out.println("Read from " + this.getFilename() + " Successfully, record size is " + records.size());
    }
    public abstract Searchable createRecordFrom(String line);
    public ArrayList<Searchable> returnAllRecords(){
        return this.records;
    }
    public boolean contains(String key){

        ArrayList<Searchable> records = returnAllRecords();
        for(Searchable record : records){
            if(record.getSearchKey().equals(key))
                return true;
        }
        return false;
    }
    public Searchable getRecord(String key){
        ArrayList<Searchable> records = returnAllRecords();
        for(Searchable record : records){
            if(record.getSearchKey().equals(key)){
                return record;
            }
        }

        System.out.println("Couldn't find record, returning null");
        return null;
    }

    public void insertRecord(Searchable record){
        ArrayList<Searchable> records = returnAllRecords();
        if(!contains(record.getSearchKey())){
           records.add(record);
        }
        else{
            System.out.println("Couldn't add record, non-unique key");
        }

    }

    public void deleteRecord(String key){
        ArrayList<Searchable> records = returnAllRecords();

        for(Searchable record : records){
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

        ArrayList<Searchable> records = returnAllRecords();

        for (Searchable record : records) {
            writer.write(record.lineRepresentation() + "\n");
        }
        writer.close();

        System.out.println("Changes saved to file successfully");
    }
}
