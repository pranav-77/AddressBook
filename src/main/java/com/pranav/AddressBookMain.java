package com.pranav;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome to the Address Book");

        AddressBook addressBook=new AddressBook();

        System.out.println("Enter First Name");
        String firstName=sc.next();

        System.out.println("Enter Last Name");
        String lastName=sc.next();

        System.out.println("Enter Address");
        String address=sc.next();

        System.out.println("Enter City");
        String city=sc.next();

        System.out.println("Enter state");
        String state=sc.next();

        System.out.println("Enter zip");
        String zip=sc.next();

        System.out.println("Enter Phone number");
        String phoneNumber=sc.next();

        System.out.println("Enter Mail");
        String mail=sc.next();

        Contact contact=new Contact(firstName, lastName, address, city, state, zip, phoneNumber, mail);

        addressBook.addContact(contact);

        addressBook.displayContacts();
    }
}
