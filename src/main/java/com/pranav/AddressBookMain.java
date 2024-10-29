package com.pranav;

import java.util.*;
import java.util.regex.Pattern;

public class AddressBookMain {
    private static Map<String, AddressBook> addressBooks = new Hashtable<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Address Book");
        while (true) {
            System.out.println("Choose Option");
            System.out.println("1. Add new Address Book");
            System.out.println("2. Select an existing Address Book");
            System.out.println("3. Display all Address Book");
            System.out.println("4. Display the contacts of a Particular AddressBook");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Enter Address Book Name");
                    String bookName = sc.nextLine();
                    if (addressBooks.containsKey(bookName)) {
                        System.out.println("Already Book Exists in this same name");
                    } else {
                        addressBooks.put(bookName, new AddressBook());
                        System.out.println("New Address Book " + bookName + " is created");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the Address Book you want to manage");
                    String selectedBook = sc.nextLine();
                    AddressBook addressBook = addressBooks.get(selectedBook);
                    if (addressBook != null) {
                        manageAddressBook(sc, addressBook);
                    } else {
                        System.out.println("Not Address Book found in given name");
                    }
                    break;
                }
                case 3: {
                    if (addressBooks.isEmpty()) {
                        System.out.println("No Address Books Present Please Add One");
                    } else {
                        System.out.println("Existing Address Book");
                        for (String name : addressBooks.keySet()) {
                            System.out.println(name);
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter the Address Book name that you need Contact details");
                    String addressBookToView = sc.nextLine();
                    AddressBook addressBook = addressBooks.get(addressBookToView);
                    if (addressBook != null) {
                        addressBook.displayContacts();
                    } else {
                        System.out.println("Address Book Not Found!");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Exiting Program...");
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid input Please enter correct option");
            }
        }
    }

    public static void manageAddressBook(Scanner sc, AddressBook addressBook) {
        while (true) {
            System.out.println("Choose one option");
            System.out.println("1. Add Contact Details");
            System.out.println("2. Review Contact Details");
            System.out.println("3. Edit Existing Contact");
            System.out.println("4. Delete Existing Contact");
            System.out.println("5. Search contacts by city and state");
            System.out.println("6. Get count of contacts by city or state");
            System.out.println("7. Sort the contacts");
            System.out.println("8. Back to Main Menu");
            int choice = sc.nextInt();
            sc.nextLine();
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

                            Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
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
                    System.out.println("Do you want to check by city or state? (Enter 'city' or 'state'):");
                    String choicee = sc.nextLine().trim().toLowerCase();
                    if (choicee.equals("city")) {
                        System.out.println("Enter city name:");
                        String city = sc.nextLine();
                        List<Contact> contacts = addressBook.getContactsByCityOrState(city, true);
                        if (contacts.isEmpty()) {
                            System.out.println("No contacts found in " + city + ".");
                        } else {
                            System.out.println("Contacts found in " + city + ":");
                            for (Contact contact : contacts) {
                                System.out.println(contact);
                            }
                        }
                    } else if (choicee.equals("state")) {
                        System.out.println("Enter state name:");
                        String state = sc.nextLine();
                        List<Contact> contacts = addressBook.getContactsByCityOrState(state, false);
                        if (contacts.isEmpty()) {
                            System.out.println("No contacts found in " + state + ".");
                        } else {
                            System.out.println("Contacts found in " + state + ":");
                            for (Contact contact : contacts) {
                                System.out.println(contact);
                            }
                        }
                    } else {
                        System.out.println("Invalid option. Please enter 'city' or 'state'.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Do you want to get count by city or state? (Enter 'city' or 'state'):");
                    String choiceCount = sc.nextLine().trim().toLowerCase();
                    if (choiceCount.equals("city")) {
                        System.out.println("Enter city name:");
                        String city = sc.nextLine();
                        long count = addressBook.countContactsByCity(city);
                        System.out.println("Number of contacts in " + city + ": " + count);
                    } else if (choiceCount.equals("state")) {
                        System.out.println("Enter state name:");
                        String state = sc.nextLine();
                        long count = addressBook.countContactsByState(state);
                        System.out.println("Number of contacts in " + state + ": " + count);
                    } else {
                        System.out.println("Invalid option. Please enter 'city' or 'state'.");
                    }
                    break;
                }
                case 7: {
                    while (true) {
                        System.out.println("Enter the choice");
                        System.out.println("1. SORT BY NAME");
                        System.out.println("2. SORT BY CITY");
                        System.out.println("3. SORT BY STATE");
                        System.out.println("4. SORT BY ZIP");
                        System.out.println("5. BACK TO MENU");
                        int option = sc.nextInt();
                        sc.nextLine();
                        switch (option) {
                            case 1: {
                                addressBook.sortContacts();
                                break;
                            }
                            case 2: {
                                addressBook.sortByCity();
                                break;
                            }
                            case 3: {
                                addressBook.sortByState();
                                break;
                            }
                            case 4: {
                                addressBook.sortByZip();
                                break;
                            }
                            case 5: {
                                System.out.println("Back to menu");
                                return;
                            }
                            default: {
                                System.out.println("Invalid Option Entered");
                            }
                        }
                    }
                }
                case 8: {
                    System.out.println("Backing To Main Menu");
                    return;
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
