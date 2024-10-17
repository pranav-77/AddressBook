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

    public void editContact(String firstName, String lastName, Scanner sc) {
        Contact contact = findContact(firstName, lastName);
        if (contact == null)
            System.out.println("Contact not found in this name please check whether the typed name is right");
        else {
            System.out.println("Editing Contact Details");
            boolean flag = true;
            while (flag) {
                System.out.println();
                System.out.println("Enter new address");
                String newAddress = sc.next();
                if (Pattern.matches("^[a-zA-Z0-9\\s,.-]+$", newAddress)) {
                    contact.setAddress(newAddress);
                    flag = false;
                } else
                    System.out.println("Invalid Address Input");
            }
            flag = true;
            while (flag) {
                System.out.println("Enter new city");
                String newCity = sc.next();
                if (Pattern.matches("^[a-zA-Z\\s]+$", newCity)) {
                    contact.setCity(newCity);
                    flag = false;
                }else
                    System.out.println("Invalid City Input");
            }
            flag = true;
            while (flag) {
                System.out.println("Enter new state");
                String newState = sc.next();
                if (Pattern.matches("^[a-zA-Z\\s]+$", newState)) {
                    contact.setState(newState);
                    flag = false;
                }else
                    System.out.println("Invalid State Input");
            }
            flag = true;
            while (flag) {
                System.out.println("Enter new zip");
                String newZip = sc.next();
                if (Pattern.matches("^[0-9]{6}$", newZip)) {
                    contact.setZip(newZip);
                    flag = false;
                }else
                    System.out.println("Invalid Zip Code Input");
            }
            flag = true;
            while (flag) {
                System.out.println("Enter new phone number");
                String newPhoneNumber = sc.next();
                if (Pattern.matches("[6-9]\\d{9}$", newPhoneNumber)) {
                    contact.setPhoneNumber(newPhoneNumber);
                    flag = false;
                }else
                    System.out.println("Invalid Phone Number Input");
            }
            flag = true;
            while (flag) {
                System.out.println("Enter new email");
                String newEmail = sc.next();
                if (Pattern.matches("^[a-zA-Z0-9_.*+-]+@[a-zA-Z]+.[a-z]+$", newEmail)) {
                    contact.setEmail(newEmail);
                    flag = false;
                }else
                    System.out.println("Invalid Email Input");
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

    public Contact findContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName))
                return contact;
        }
        return null;
    }


}
