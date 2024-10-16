package com.pranav;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts=new ArrayList<>();

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public void displayContacts(){
        if (contacts.isEmpty())
            System.out.println("There is no contacts available to see");
        for (Contact contact:contacts)
            System.out.println(contact);
    }
}
