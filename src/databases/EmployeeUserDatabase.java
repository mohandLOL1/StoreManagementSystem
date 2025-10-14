package databases;

import users.EmployeeUser;


import java.io.*;
import java.util.ArrayList;

public class EmployeeUserDatabase extends DataBase<EmployeeUser> {

    public EmployeeUserDatabase(String filename) {
        super(filename);
    }


    @Override
    public void readFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(getFilename()));
        String line;
        ArrayList<EmployeeUser> records = returnAllRecords();

        while((line = reader.readLine()) != null){

            line = line.trim();
            if (line.isEmpty()) continue;
            records.add(createRecordFrom(line));
        }
        reader.close();
        System.out.println("Read from " + this.getFilename() + " Successfully, record size is " + records.size());
    }

    @Override
    public EmployeeUser createRecordFrom(String line) {


        line = line.trim();
        if (line.isEmpty()) {
            System.err.println("Skipping empty line in file.");
            return null;
        }

        String[] tokens = line.split(",");

        if (tokens.length < 5) {
            System.err.println("Malformed line (expected 5 tokens): " + line);
            return null;
        }

        String ID;
        String name;
        String email;
        String address;
        String phoneNumber;

        ID = tokens[0];
        name = tokens[1];
        email = tokens[2];
        address = tokens[3];
        phoneNumber = tokens[4];

        return new EmployeeUser(ID,name,email,address,phoneNumber);
    }


    @Override
    public void saveToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(getFilename()));

        ArrayList<EmployeeUser> records = returnAllRecords();

        for(int i = 0 ;i<records.size();i++){
            writer.write(records.get(i).lineRepresentation() + "\n");
        }
        writer.close();

        System.out.println("Changes saved to file successfully");
    }
}
