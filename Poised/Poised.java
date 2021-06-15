package com.kekeletso;

import java.util.Scanner;

public class Poised {

    public static void main(String[] args) {
        /* Capstone Project II - Refactoring
        * Civil Engineering company called Poised
        * Project details and Contacts attributes initialised
        * User input for each project required to create each project object*/

        String projectName;
        String projectNumber;
        String buildingType;
        String projectAddress;
        String erfNumber;
        String totalCost;
        String amountPaid;
        String projectDeadline;
        String projectProgress;
        String customer;
        String architect;
        String contractor;

        //Contacts attributes
        String fullName;
        String cellNumber;
        String email;
        String address;
        String firstName;
        String lastName;

        //Get user inputs for Project details needed to create the project
        Scanner input = new Scanner(System.in);
        System.out.print("\nCreate new project name: ");
        projectName = input.nextLine();

        System.out.print("\nProject Number: ");
        projectNumber = input.nextLine();

        System.out.print("\nBuilding Type. \nApartment Block, House or Store: ");
        buildingType = input.nextLine();

        System.out.print("\nProject Address: ");
        projectAddress = input.nextLine();

        System.out.print("\nEnter a ERF Number: ");
        erfNumber = input.nextLine();

        System.out.print("\nTotal cost of the project: ");
        totalCost = input.nextLine();

        System.out.print("\nAmount Paid: ");
        amountPaid = input.nextLine();

        System.out.print("\nProject Deadline: ");
        projectDeadline = input.nextLine();

        System.out.print("\nProgress of project. \nComplete, In-Progress: ");
        projectProgress = input.nextLine();

        //Request Contacts information to put into original Project details
        //Customer first and last name separated to include last name in project name if project name not included
        System.out.print("\nCustomer First Name: ");
        firstName = input.nextLine();
        System.out.print("\nCustomer Last Name: ");
        lastName = input.nextLine();
        fullName = firstName + " " + lastName;

        System.out.print("\nCustomer Cell Number: ");
        cellNumber = input.nextLine();
        System.out.print("\nCustomer Email Address: ");
        email = input.nextLine();
        System.out.print("\nCustomer Address: ");
        address = input.nextLine();
        customer = fullName + "\n" + cellNumber + "\n" + email + "\n" + address;

        System.out.print("\nArchitect Name: ");
        fullName = input.nextLine();
        System.out.print("\nArchitect Cell Number: ");
        cellNumber = input.nextLine();
        System.out.print("\nArchitect Email Address: ");
        email = input.nextLine();
        System.out.print("\nArchitect Address: ");
        address = input.nextLine();
        architect = fullName + "\n" + cellNumber  + "\n" + email + "\n" + address;

        System.out.print("\nContractor Name: ");
        fullName = input.nextLine();
        System.out.print("\nContractor Cell Number: ");
        cellNumber = input.nextLine();
        System.out.print("\nContractor Email Address: ");
        email = input.nextLine();
        System.out.print("\nContractor Address: ");
        address = input.nextLine();
        contractor = fullName + "\n" + cellNumber  + "\n" + email + "\n" + address;

        //If project name not provided, then the project name becomes the Building type and customer last name
        //try catch exception for inputs that may be numbers or special characters
        try {

            if (projectName.equals(" ")) {
                projectName = buildingType + lastName;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong. \nEnter a project name or press the space bar. ");
        }

        System.out.println("\nNew Project created.");

        // Object for project details created
        ProjectDetails project1 = new ProjectDetails(projectName, projectNumber, buildingType, projectAddress,
                erfNumber, totalCost, amountPaid, projectDeadline, projectProgress, customer, architect, contractor);
        System.out.println(project1.toString());

        /*while loop for options to edit the project details
        * if statements for each option when selected with upper and lower case independent*/

        do {

            try {
                System.out.println(" Choose from the options below to edit the Project: " +
                        "\n(E) Edit project. \n(C) Edit the Contractor. \n(F) Finalize project.");

                String projectEdit = input.nextLine();

                /*Edit project option allows for user edit the project deadline or amount paid
                 * Each attribute changed for the project1
                 * updated project details displayed after each edit*/
                if ((projectEdit.equals("E")) || (projectEdit.equals("e"))) {
                    System.out.println("Would you like to edit: \n1. Project Deadline. \n2. Amount Paid.");
                    String userChoice = input.nextLine();
                    if (userChoice.equals("1")) {
                        System.out.print("Enter new Project Deadline: ");
                        project1.deadline = input.nextLine();
                        System.out.println("Project Deadline updated to " + projectDeadline);

                        System.out.println(project1.toString());

                    } else if (userChoice.equals("2")) {
                        System.out.print("How much has been paid so far: ");
                        project1.amountPaid = input.nextLine();
                        System.out.println("R" + amountPaid + " has been paid so far.");

                        System.out.println(project1.toString());
                    }
                    /*Edit Contractor option allows for user to edit the the contractor's contact details
                     * Contacts class called
                     * updated Contractor details displayed after each edit*/
                } else if ((projectEdit.equals("C")) || (projectEdit.equals("c"))) {
                    System.out.print("Enter new Contractor's name:");
                    fullName = input.nextLine();
                    System.out.print("Enter new Contractor's number: ");
                    cellNumber = input.nextLine();
                    System.out.println("Enter new Contractor's address: ");
                    address = input.nextLine();

                    project1.contractor = fullName + "\n" + cellNumber + "\n" + address;

                    // Created contractor object for Contacts class
                    Contacts project1Contactor = new Contacts(fullName, cellNumber, email, address);
                    System.out.println("Contractor information updated: " + project1Contactor.toString());
                    System.out.println("\n" + fullName + " added as the new Contractor for Project: " + projectName);
                    System.out.println(project1.toString());
                }
                /* Project can be finalised if Finalise option selected
                 * If input is Y, project progress updated to complete
                 * program ends */

                else if ((projectEdit.equals("F")) || (projectEdit.equals("f"))) {
                    System.out.print("Would you like to finalise the project? Y/N: ");
                    String complete = input.nextLine();
                    if (complete.equals("Y") || (complete.equals("y"))) {
                        project1.progress = "Complete";

                        //Total amount that is outstanding calculated and displayed once project is Finalized
                        // String variables converted to Integers for calculations with parseInt
                        System.out.println("\n" + projectName + " Project Finalized.");
                        int outstanding = Integer.parseInt(totalCost) - Integer.parseInt(amountPaid);
                        System.out.println("R" + outstanding + " still needs to be paid.");
                        System.out.println(project1.toString());
                        break;
                    } else if (complete.equals("N") || (complete.equals("n"))) {
                        System.out.println("Project not yet complete.");
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Please select from the relevant options.");
            }
        } while (true);
    }
}
