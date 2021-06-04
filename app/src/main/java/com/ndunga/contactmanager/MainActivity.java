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
        Contact json = new Contact();
        json.setName("Allenr");
        json.setPhoneNumber("014616141");

        //cursor.
//        contact.setName("Everson Ali");
//        contact.setPhoneNumber("7673732873");

        //databaseHandler.createContact(json);
        List<Contact> contactList = databaseHandler.getAllContacts();

        for (Contact contact:contactList){

            Log.d("GET:::",contact.getName());
            System.out.println("GET:"+contact.getName());
        };
    }
}