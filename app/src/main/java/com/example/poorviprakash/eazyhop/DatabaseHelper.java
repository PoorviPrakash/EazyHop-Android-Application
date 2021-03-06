package com.example.poorviprakash.eazyhop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="contacts.db";
    private static final String TABLE_NAME ="contacts";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_NAME ="name";
    private static final String COLUMN_EMAIL ="email";
    private static final String COLUMN_PHONENO ="phone_no";
    private static final String COLUMN_PASSWORD ="password";
    SQLiteDatabase db;

    private static final String TABLE_CREATE ="create table contacts (id integer primary key not null, "+" name text not null, email text not null unique, phone_no text not null, password text not null);";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertContact(Contact c){
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count=cursor.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_PHONENO,c.getPhoneno());
        values.put(COLUMN_PASSWORD, c.getPassword());

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);
        db.close();
    }

    public String searchPass(String email){
        db=this.getReadableDatabase();
        String query = "select email, password from "+ TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String e,p;
        p="Not found";
        {
            if(cursor.moveToFirst()){
                do{
                    e=cursor.getString(0).trim();

                    if(e.equals(email)){
                        p = cursor.getString(1).trim();
                        break;
                    }
                }while(cursor.moveToNext());
            }
        }
        return p;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
