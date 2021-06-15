package com.kekeletso;

public class ProjectDetails {
    //Needed information for each project
    String name;
    String projectNumber;
    String type;
    String projectAddress;
    String erfNumber;
    String totalCost;
    String amountPaid;
    String deadline;
    String progress;
    String customer;
    String architect;
    String contractor;

    //Constructor method to initialise each attribute
    public ProjectDetails(String name, String projectNumber, String type, String projectAddress,
            String erfNumber, String totalCost, String amountPaid, String deadline,
            String progress, String customer, String architect, String contractor) {

        this.name = name;
        this.projectNumber = projectNumber;
        this.type = type;
        this.projectAddress = projectAddress;
        this.erfNumber = erfNumber;
        this.totalCost = totalCost;
        this.amountPaid = amountPaid;
        this.deadline = deadline;
        this.progress = progress;
        this.customer = customer;
        this.architect = architect;
        this.contractor = contractor;
    }

    //toString method for our attributes
    public String toString() {
        System.out.println("\nProject Details.");
        String output = "\nProject Name: " + name;
        output += "\nProject Number: " + projectNumber;
        output += "\nBuilding Type: " + type;
        output += "\nBuilding Address: " + projectAddress;
        output += "\nERF Number: " + erfNumber;
        output += "\nTotal Project Cost: R" + totalCost;
        output += "\nAmount Paid: R" + amountPaid;
        output += "\nProject Deadline: " +  deadline;
        output += "\nProgress of Project: " +  progress;
        output += "\nCustomer Details: " +  customer;
        output += "\nArchitect Details: " +  architect;
        output += "\nContractor Details: " +  contractor;

        return output;

    }
}
