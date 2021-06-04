package com.ndunga.contactmanager.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ndunga.contactmanager.R;
import com.ndunga.contactmanager.model.Contact;
import com.ndunga.contactmanager.utils.Util;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE "+ Util.TABLE_NAME + "(" +
                Util.KEY_ID + " INTEGER PRIMARY KEY," + Util.KEY_NAME +
                " TEXT,"+Util.KEY_PHONE_NUMBER+ "TEXT)";

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE = String.valueOf(R.string.drop_table_text);

        db.execSQL(DROP_TABLE, new String[]{Util.TABLE_NAME});

        //after drop, create a new table, call onCreate method.
        onCreate(db);

    }

    private void createContact(Contact contact) {

        //GET writable db
        SQLiteDatabase db = this.getWritableDatabase();

        //instantiate contentvalues
        ContentValues contentValues = new ContentValues();

        //no need to create an id record, they are autocreate
        contentValues.put(Util.KEY_NAME,contact.getName());
        contentValues.put(Util.KEY_PHONE_NUMBER,contact.getPhoneNumber());

        //insert to db
        db.insert(Util.TABLE_NAME,null,contentValues);

        //after insert,close db
        db.close();

    }

    private Contact getContact(int id){
        //GET getReadable
        SQLiteDatabase db = this.getReadableDatabase();

        //call Cursor
        Cursor cursor = db.query(Util.TABLE_NAME,
                new String[]{Util.KEY_ID,Util.KEY_NAME,Util.KEY_PHONE_NUMBER},
                Util.KEY_ID + "=?",new String[]{String.valueOf(id)},
                null,null,null);

        //check cursor
        if(cursor != null) {
            cursor.moveToFirst();
        }

        //create a contact obj
        Contact contact = new Contact();

        contact.setId(Integer.parseInt(cursor.getString(0)));
        contact.setName(cursor.getString(1));
        contact.setPhoneNumber(cursor.getString(2));

        return contact;
    }
}
