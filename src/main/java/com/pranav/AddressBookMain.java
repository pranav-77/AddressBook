package com.pranav;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AddressBookMain {
    public static void main(String[] args) throws ContactException {
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
                        try {
                            System.out.println("Enter First Name eg:Alan");
                            String firstName = sc.next();
                            validateName(firstName);

                            System.out.println("Enter Last Name eg:John");
                            String lastName = sc.next();
                            validateName(lastName);

                            System.out.println("Enter Address eg: 5th,Street-HSR");
                            String address = sc.next();
                            validateAddress(address);

                            System.out.println("Enter City eg: Bangalore");
                            String city = sc.next();
                            validateCityAndState(city);

                            System.out.println("Enter State eg: Karnataka");
                            String state = sc.next();
                            validateCityAndState(state);

                            System.out.println("Enter Zip eg: 564534");
                            String zip = sc.next();
                            validateZip(zip);

                            System.out.println("Enter Phone number eg: 9876543210");
                            String phoneNumber = sc.next();
                            validatePhoneNumber(phoneNumber);

                            System.out.println("Enter Mail eg: hello@gmail.com");
                            String email = sc.next();
                            validateEmail(email);

                            Contact contact = new Contact(firstName, lastName, address, state, city, zip, phoneNumber, email);
                            addressBook.addContact(contact);
                            break;
                        } catch (ContactException e) {
                            System.out.println(e.getMessage() + " Please Try Again...");
                        }
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

    public static void validateName(String name) throws ContactException {
        if (!Pattern.matches("^[A-Z][a-zA-Z]{1,}$", name))
            throw new ContactException("Invalid Name -Check the given eg");
    }

    public static void validateAddress(String address) throws ContactException {
        if (!Pattern.matches("^[a-zA-Z0-9\\s,.-]+$", address))
            throw new ContactException("Invalid Address -Check the given eg");
    }

    public static void validateCityAndState(String cityAndState) throws ContactException {
        if (!Pattern.matches("^[a-zA-Z\\s]+$", cityAndState))
            throw new ContactException("Invalid input  -Check the given eg");
    }

    public static void validateZip(String zip) throws ContactException {
        if (!Pattern.matches("^[0-9]{6}$", zip))
            throw new ContactException("Invalid Zip Code  -Check the given eg");
    }

    public static void validatePhoneNumber(String phoneNumber) throws ContactException {
        if (!Pattern.matches("[6-9]\\d{9}$", phoneNumber))
            throw new ContactException("Invalid Phone number  -Check the given eg");
    }

    public static void validateEmail(String mail) throws ContactException {
        if (!Pattern.matches("^[a-zA-Z0-9_.*+-]+@[a-zA-Z]+.[a-z]+$", mail))
            throw new ContactException("Invalid Mail id  -Check the given eg");
    }
}
