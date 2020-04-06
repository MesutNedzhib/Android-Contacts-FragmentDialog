package com.example.appcontacts.contact;

import java.util.ArrayList;

public class ContactSource {

    private static ArrayList<Contact> contacts;

    public ContactSource() {
        contacts = new ArrayList<>();
    }

    public static ArrayList<Contact> getContacts(){
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Ivan Ivanov","0894936658"));
        contacts.add(new Contact("Zlatin Zlatev","0894936678"));
        return contacts;
    }

    public static boolean contactAdd(String name,String phone){
        return  contacts.add(new Contact(name,phone));
    }
}
