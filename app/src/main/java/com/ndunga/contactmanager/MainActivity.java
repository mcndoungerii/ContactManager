package com.ndunga.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ndunga.contactmanager.data.DatabaseHandler;
import com.ndunga.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);

        //create contact to save to db


        //call get one contact method
        Contact contact = databaseHandler.getContact(2);

        Log.d("GET one", String.valueOf(contact));

        contact.setName("Josep");
        contact.setPhoneNumber("014616141");

        //call update method

        int updateContact = databaseHandler.updateContact(contact);

        Log.d("Update", String.valueOf(updateContact));



       // Contact json = new Contact();
        //databaseHandler.createContact(json);
        List<Contact> contactList = databaseHandler.getAllContacts();

        for (Contact contact1:contactList){

            Log.d("GET:::",contact1.getName());
        };
    }
}