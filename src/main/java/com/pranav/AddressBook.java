package com.pranav;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

//    public AddressBook(){
//        this.contacts=new ArrayList<>();
//    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact Added Successfully");
    }

    public void displayContacts() {
        if (contacts.isEmpty())
            System.out.println("There is no contacts available to see");
        for (Contact contact : contacts)
            System.out.println(contact);
    }

    public void editContact(String firstName, String lastName, Scanner sc) {
        Contact contact = findContact(firstName, lastName);
        if (contact == null)
            System.out.println("Contact not found");
        else {
            System.out.println("Editing Contact Details");
            System.out.println();
            System.out.println("Enter new address");
            String newAddress = sc.next();
            if (!newAddress.isEmpty())
                contact.setAddress(newAddress);

            System.out.println("Enter new city");
            String newCity = sc.next();
            if (!newCity.isEmpty())
                contact.setCity(newCity);

            System.out.println("Enter new state");
            String newState = sc.next();
            if (!newState.isEmpty())
                contact.setState(newState);

            System.out.println("Enter new zip");
            String newZip = sc.next();
            if (!newZip.isEmpty())
                contact.setZip(newZip);

            System.out.println("Enter new phone number");
            String newPhoneNumber = sc.next();
            if (!newPhoneNumber.isEmpty())
                contact.setPhoneNumber(newPhoneNumber);

            System.out.println("Enter new email");
            String newEmail = sc.next();
            if (!newEmail.isEmpty())
                contact.setEmail(newEmail);

            System.out.println();
            System.out.println("Updated Successfully...");
        }
    }

    public void deleteContact(String firstName, String lastName) {
        Contact contact = findContact(firstName, lastName);
        if (contact == null)
            System.out.println("Contact not found");
        else {
            contacts.remove(contact);
            System.out.println("Contact Removed Successfully...");
        }
    }

    private Contact findContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName))
                return contact;
        }
        return null;
    }
}
