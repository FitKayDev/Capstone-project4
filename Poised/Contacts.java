package com.kekeletso;

public class Contacts {
    /*Class for Customer, Architect and Contractor information
    * Attributes for all required information for each person*/
    String fullName;
    String cellNumber;
    String email;
    String address;

    //Constructor to initialise our attributes

    public Contacts(String fullName, String cellNumber, String email, String address) {
        this.fullName = fullName;
        this.cellNumber = cellNumber;
        this.email = email;
        this.address = address;

    }

    public String toString() {
        System.out.print("Contact's Information. ");
        String output = "\nFull Name: " + fullName;
        output += "\nCell Number: " + cellNumber;
        output += "\nEmail Address: " + email;
        output += "\nHome Address: " + address;

        return output;
    }

}
