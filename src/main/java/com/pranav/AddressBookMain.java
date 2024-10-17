package com.pranav;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Address Book");
        while (true) {
            System.out.println("Choose one option");
            System.out.println("1. Add Contact Details");
            System.out.println("2. Review Contact Details");
            System.out.println("3. Edit Existing Contact");
            System.out.println("4. Delete Existing Contact");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    while (true) {
                        System.out.println("Enter First Name");
                        String firstName = sc.next();
                        if (!Pattern.matches("^[A-Z][a-zA-Z]{1,}$", firstName)) {
                            System.out.println("Invalid First Name");
                            continue;
                        }

                        System.out.println("Enter Last Name");
                        String lastName = sc.next();
                        if (!Pattern.matches("^[A-Z][a-zA-Z]{1,}$", lastName)) {
                            System.out.println("Invalid Last Name");
                            continue;
                        }

                        System.out.println("Enter Address Name");
                        String address = sc.next();
                        if (!Pattern.matches("^[a-zA-Z0-9\\s,.-]+$", address)) {
                            System.out.println("Invalid Address Input");
                            continue;
                        }

                        System.out.println("Enter City");
                        String city = sc.next();
                        if (!Pattern.matches("^[a-zA-Z\\s]+$", city)) {
                            System.out.println("Invalid City Input");
                            continue;

                        }

                        System.out.println("Enter State");
                        String state = sc.next();
                        if (!Pattern.matches("^[a-zA-Z\\s]+$", state)) {
                            System.out.println("Invalid State Input");
                            continue;
                        }

                        System.out.println("Enter Zip");
                        String zip = sc.next();
                        if (!Pattern.matches("^[0-9]{6}$", zip)) {
                            System.out.println("Invalid Zip Input");
                            continue;
                        }

                        System.out.println("Enter Phone number");
                        String phoneNumber = sc.next();
                        if (!Pattern.matches("[6-9]\\d{9}$", phoneNumber)) {
                            System.out.println("Invalid Phone Number");
                            continue;
                        }
                        System.out.println("Enter Mail");
                        String email = sc.next();
                        if (!Pattern.matches("^[a-zA-Z0-9_.*+-]+@[a-zA-Z]+.[a-z]+$", email)) {
                            System.out.println("Invalid Mail");
                            continue;
                        }

                        Contact contact = new Contact(firstName, lastName, address, state, city, zip, phoneNumber, email);
                        addressBook.addContact(contact);
                        break;
                    }
                    break;
                }
                case 2: {
                    addressBook.displayContacts();
                    break;
                }
                case 3: {
                    System.out.println("Enter the first name:");
                    String editFirstName = sc.next();
                    System.out.println("Enter the last name:");
                    String editLastName = sc.next();
                    addressBook.editContact(editFirstName, editLastName, sc);
                    break;
                }
                case 4: {
                    System.out.println("Enter the First Name");
                    String deleteFirstName = sc.next();
                    System.out.println("Enter the Last Name");
                    String deleteLastName = sc.next();
                    addressBook.deleteContact(deleteFirstName, deleteLastName);
                    break;
                }
                case 5: {
                    System.out.println("Exiting Program....");
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
