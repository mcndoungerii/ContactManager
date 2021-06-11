package com.ndunga.contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ndunga.contactmanager.data.DatabaseHandler;
import com.ndunga.contactmanager.databinding.ActivityMainBinding;
import com.ndunga.contactmanager.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ArrayList<String> contactArrayList;

    private ArrayAdapter<String> adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);

        //1. Initialize arraylist
        contactArrayList = new ArrayList<>();





        //create contact to save to db


        //call get one contact method
        //Contact contact = databaseHandler.getContact(1);
        //
        //Log.d("GET one", String.valueOf(contact));


        //create contact

        Contact contact = new Contact();
        contact.setName("Joe");
        contact.setPhoneNumber("014616141");

        //databaseHandler.createContact(contact);

        //call update method

//        int updateContact = databaseHandler.updateContact(contact);
//
//        Log.d("Update", String.valueOf(updateContact));

        //delete contact.
        //databaseHandler.deleteContact(contact);

       // Contact json = new Contact();
        databaseHandler.createContact(contact);

        //GET COUNT.

        int counter = databaseHandler.getContact();
        Log.d("Counter:::", String.valueOf(counter));
        List<Contact> contactList = databaseHandler.getAllContacts();

        for (Contact contact1:contactList){

            Log.d("GET:::","id: "+contact1.getId()+","+"Name: "+contact1.getName());

            contactArrayList.add(contact1.getName());
        };
        //2.Initialize adapter.
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,contactArrayList);

        //3. setting adapter with the ListView
        binding.listView.setAdapter(adapter);

        //4.listern to listView events
        binding.listView.setOnItemClickListener((parent, view, position, id) -> {

            Log.d("Item","On Item Clicked "+contactArrayList.get(position));

        });
    }
}