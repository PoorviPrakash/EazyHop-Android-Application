package com.example.poorviprakash.eazyhop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BusAirDataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="airbusdetails.db";
    private static final String TABLE_NAME ="airbusdetails";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_SOURCEPLACE ="sourcePlace";
    private static final String COLUMN_DESTINATIONPLACE ="destinationPlace";
    private static final String COLUMN_ADULTPRICE ="adultPrice";
    //private static final String COLUMN_CHILDPRICE ="childPrice";
    //private static final String COLUMN_SRCITIZENPRICE ="srCitizenPrice";

    SQLiteDatabase db;

    private static final String TABLE_CREATE ="create table airbusdetails (id integer primary key not null, "+" sourcePlace text not null, destinationPlace text not null, adultPrice integer not null);";


    public BusAirDataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertRows(){
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from airbusdetails ";
        Cursor cursor = db.rawQuery(query,null);
        int count=cursor.getCount();


        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Bengaluru Dairy Circle");
        values.put(COLUMN_DESTINATIONPLACE,"Kempegowda International Airport");
        values.put(COLUMN_ADULTPRICE,220);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);

        query = "select * from airbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();


        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Wilson Garden Police Station");
        values.put(COLUMN_DESTINATIONPLACE,"Kempegowda International Airport");
        values.put(COLUMN_ADULTPRICE,210);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);

        query = "select * from airbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Mekhri Circle");
        values.put(COLUMN_DESTINATIONPLACE,"Kempegowda International Airport");
        values.put(COLUMN_ADULTPRICE,175);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);


        query = "select * from airbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Hebbala");
        values.put(COLUMN_DESTINATIONPLACE,"Kempegowda International Airport");
        values.put(COLUMN_ADULTPRICE,150);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);

        query = "select * from airbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Allalasandra Gate");
        values.put(COLUMN_DESTINATIONPLACE,"Kempegowda International Airport");
        values.put(COLUMN_ADULTPRICE,140);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);


        query = "select * from airbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Kogilu Cross");
        values.put(COLUMN_DESTINATIONPLACE,"Kempegowda International Airport");
        values.put(COLUMN_ADULTPRICE,125);


        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);


        query = "select * from airbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Sadahalli Gate");
        values.put(COLUMN_DESTINATIONPLACE,"Kempegowda International Airport");
        values.put(COLUMN_ADULTPRICE,100);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);

        db.close();
    }


    public int searchRows(int index){
        db=this.getReadableDatabase();
        String query = "select id,adultPrice from "+ TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        int fare=0;
        {
            if(cursor.moveToFirst()){
                do{
                    if(cursor.getInt(0)==index){
                        fare=cursor.getInt(1);
                        Log.d("ta", "searchRows: " + fare);
                    }
                }while(cursor.moveToNext());
            }

        }
        Log.d("Array", "searchRows: " + fare);
        return fare;
    }
}
