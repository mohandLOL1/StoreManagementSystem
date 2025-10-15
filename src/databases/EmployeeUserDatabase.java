package databases;

import users.EmployeeUser;


import java.io.*;

public class EmployeeUserDatabase extends DataBase<EmployeeUser> {

    public EmployeeUserDatabase(String filename) {
        super(filename);
    }

    @Override
    public EmployeeUser createRecordFrom(String line) {


        String[] tokens = line.split(",");

        if (tokens.length != 5) {
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
}
