package com.pranav;

import java.util.regex.Pattern;

public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String state, String city, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    private boolean validateName(String name) {
        return Pattern.matches("[A-Z][a-z]{1,15}+", name);
    }

    private boolean validateAddress(String address) {
        return Pattern.matches("[A-Za-z0-9\\s,.]{5,25}+", address);
    }

    private boolean validateCityAndState(String cityAndState) {
        return Pattern.matches("[A-Z][a-z]{1,10}+", cityAndState);
    }

    private boolean validateZip(String zip) {
        return Pattern.matches("[0-9]{6}+", zip);
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        return Pattern.matches("91\\s[6-9]\\d{9}$", phoneNumber);
    }

    private boolean validateEmail(String email) {
        return Pattern.matches("[a-zA-Z0-9_.*+-]+@[a-zA-Z]+.[a-z]+$", email);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (validateEmail(firstName))
            this.firstName = firstName;
        else
            System.out.println("Invalid Input");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact Details:\n" + "NAME: " + firstName + " " + lastName + "\n" + "ADDRESS: " + address + "\n" + "CITY: " + city + "\n" + "STATE: " + state + "\n" + "ZIP: " + zip + "\n" + "PHONE NO: " + phoneNumber + "\n" + "EMAIL: " + email + "\n";
    }
}

