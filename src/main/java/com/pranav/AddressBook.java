package com.pranav;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    List<Contact> contacts = new ArrayList<>();
    static int count = 0;

    public void addContact(Contact contact) {
        boolean exists = contacts.stream().anyMatch(c -> c.equals(contact));
        if (!exists) {
            contacts.add(contact);
            count++;
            System.out.println("Contact Added Successfully");
        } else {
            System.out.println("Contact with the same first name and last name is already present.");
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty())
            System.out.println("The Contacts List is Empty Add Some Contacts By Choosing Option 1");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public Contact findContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName))
                return contact;
        }
        return null;
    }

    public void editContact(String firstName, String lastName, Scanner sc) {
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
                    AddressBookMain.validateAddress(newAddress);
                    contact.setAddress(newAddress);

                    System.out.println("Enter new city eg: Bangalore");
                    String newCity = sc.next();
                    AddressBookMain.validateCityAndState(newCity);
                    contact.setCity(newCity);

                    System.out.println("Enter new state eg: Karnataka");
                    String newState = sc.next();
                    AddressBookMain.validateCityAndState(newState);
                    contact.setState(newState);

                    System.out.println("Enter new zip eg:676765");
                    String newZip = sc.next();
                    AddressBookMain.validateZip(newZip);
                    contact.setZip(newZip);

                    System.out.println("Enter new phone number eg: 9090987867");
                    String newPhoneNumber = sc.next();
                    AddressBookMain.validatePhoneNumber(newPhoneNumber);
                    contact.setPhoneNumber(newPhoneNumber);

                    System.out.println("Enter new email eg: hello@gmail.com");
                    String newEmail = sc.next();
                    AddressBookMain.validateEmail(newEmail);
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

    public List<Contact> getContactsByCityOrState(String value, boolean isCity) {
        return contacts.stream()
                .filter(contact -> {
                    if (isCity) {
                        return contact.getCity().equalsIgnoreCase(value);
                    } else {
                        return contact.getState().equalsIgnoreCase(value);
                    }
                })
                .collect(Collectors.toList());
    }

    public long countContactsByCity(String city) {
        return contacts.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .count();
    }

    public long countContactsByState(String state) {
        return contacts.stream()
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .count();
    }
}
