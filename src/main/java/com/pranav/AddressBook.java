package com.pranav;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();
    static int count = 0;
//    public AddressBook(){
//        this.contacts=new ArrayList<>();
//    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        count++;
        System.out.println("Contact Added Successfully");
    }

    public void displayContacts() {
        if (contacts.isEmpty())
            System.out.println("The Contacts List is Empty Add Some Contacts By Choosing Option 1");
        for (Contact contact : contacts)
            System.out.println(contact);
    }

    public Contact findContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName))
                return contact;
        }
        return null;
    }

    public void editContact(String firstName, String lastName, Scanner sc) throws ContactException {
        Contact contact = findContact(firstName, lastName);
        if (contact == null)
            System.out.println("Contact not found in this name please check whether the typed name is correct");
        else {
            System.out.println("Editing Contact Details");
            while (true) {
                try {
                    System.out.println();
                    System.out.println("Enter new address eg: 5,HSR-Layout");
                    String newAddress = sc.next();
                    validateAddress(newAddress);
                    contact.setAddress(newAddress);

                    System.out.println("Enter new city eg: Bangalore");
                    String newCity = sc.next();
                    validateCityAndState(newCity);
                    contact.setCity(newCity);

                    System.out.println("Enter new state eg: Karnataka");
                    String newState = sc.next();
                    validateCityAndState(newState);
                    contact.setState(newState);

                    System.out.println("Enter new zip eg:676765");
                    String newZip = sc.next();
                    validateZip(newZip);
                    contact.setZip(newZip);

                    System.out.println("Enter new phone number eg: 9090987867");
                    String newPhoneNumber = sc.next();
                    validatePhoneNumber(newPhoneNumber);
                    contact.setPhoneNumber(newPhoneNumber);

                    System.out.println("Enter new email eg: hello@gmail.com");
                    String newEmail = sc.next();
                    validateEmail(newEmail);
                    contact.setEmail(newEmail);
                    break;
                } catch (ContactException e) {
                    System.out.println(e.getMessage() + " Please try again...");
                }
            }
            System.out.println();
            System.out.println("Contact Updated Successfully...");
        }
    }

    public void deleteContact(String firstName, String lastName) {
        Contact contact = findContact(firstName, lastName);
        if (contact == null)
            System.out.println("Contact not found");
        else {
            contacts.remove(contact);
            count--;
            System.out.println("Contact Deleted Successfully...");
        }
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
