package com.example.poorviprakash.eazyhop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BusNonAcDatsBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="nonacbusdetails.db";
    private static final String TABLE_NAME ="nonacbusdetails";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_SOURCEPLACE ="sourcePlace";
    private static final String COLUMN_DESTINATIONPLACE ="destinationPlace";
    private static final String COLUMN_ADULTPRICE ="adultPrice";
    private static final String COLUMN_CHILDPRICE ="childPrice";
    private static final String COLUMN_SRCITIZENPRICE ="srCitizenPrice";

    SQLiteDatabase db;

    private static final String TABLE_CREATE ="create table nonacbusdetails (id integer primary key not null, "+" sourcePlace text not null, destinationPlace text not null, adultPrice integer not null, childPrice integer not null, srCitizenPrice integer not null);";


    public BusNonAcDatsBaseHelper(Context context){
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

        String query = "select * from nonacbusdetails ";
        Cursor cursor = db.rawQuery(query,null);
        int count=cursor.getCount();


        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Hebbala");
        values.put(COLUMN_DESTINATIONPLACE,"Manyatha Tech Park");
        values.put(COLUMN_ADULTPRICE,11);
        values.put(COLUMN_CHILDPRICE, 6);
        values.put(COLUMN_SRCITIZENPRICE,9);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);

        query = "select * from nonacbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();


        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Manyatha Tech Park");
        values.put(COLUMN_DESTINATIONPLACE,"Kalyananagara Bus Stand");
        values.put(COLUMN_ADULTPRICE,7);
        values.put(COLUMN_CHILDPRICE, 5);
        values.put(COLUMN_SRCITIZENPRICE,6);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);

        query = "select * from nonacbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Kalyananagara Bus Stand");
        values.put(COLUMN_DESTINATIONPLACE,"Ramamurthy Nagara");
        values.put(COLUMN_ADULTPRICE,9);
        values.put(COLUMN_CHILDPRICE, 7);
        values.put(COLUMN_SRCITIZENPRICE,7);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);


        query = "select * from nonacbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Ramamurthy Nagara");
        values.put(COLUMN_DESTINATIONPLACE,"K R Puram");
        values.put(COLUMN_ADULTPRICE,9);
        values.put(COLUMN_CHILDPRICE, 6);
        values.put(COLUMN_SRCITIZENPRICE,7);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);

        query = "select * from nonacbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "K R Puram");
        values.put(COLUMN_DESTINATIONPLACE,"EMC2");
        values.put(COLUMN_ADULTPRICE,11);
        values.put(COLUMN_CHILDPRICE, 9);
        values.put(COLUMN_SRCITIZENPRICE,7);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);


        query = "select * from nonacbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "EMC2");
        values.put(COLUMN_DESTINATIONPLACE,"Marathahalli Bridge");
        values.put(COLUMN_ADULTPRICE,11);
        values.put(COLUMN_CHILDPRICE, 7);
        values.put(COLUMN_SRCITIZENPRICE,9);


        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);


        query = "select * from nonacbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Marathahalli Bridge");
        values.put(COLUMN_DESTINATIONPLACE,"New Horizon College of Engineering");
        values.put(COLUMN_ADULTPRICE,9);
        values.put(COLUMN_CHILDPRICE, 7);
        values.put(COLUMN_SRCITIZENPRICE,7);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);


        query = "select * from nonacbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "New Horizon College of Engineering");
        values.put(COLUMN_DESTINATIONPLACE,"Sarjapura Cross");
        values.put(COLUMN_ADULTPRICE,12);
        values.put(COLUMN_CHILDPRICE, 10);
        values.put(COLUMN_SRCITIZENPRICE,11);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);


        query = "select * from nonacbusdetails";
        cursor = db.rawQuery(query,null);
        count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_SOURCEPLACE, "Sarjapura Cross");
        values.put(COLUMN_DESTINATIONPLACE,"Central Silk Board");
        values.put(COLUMN_ADULTPRICE,11);
        values.put(COLUMN_CHILDPRICE, 7);
        values.put(COLUMN_SRCITIZENPRICE,9);

        db.insert(TABLE_NAME, null, values);
        Log.d("Number of rows", "insertContact: "+ count);


        db.close();
    }


    public int[] searchRows(int startIndex, int lastIndex){
        db=this.getReadableDatabase();
        String query = "select id,adultPrice, childPrice,srCitizenPrice from "+ TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        int ta=0,tc=0,ts=0;
        int[] array=new int[3];
        {
            if(cursor.moveToFirst()){
                do{
                    if(cursor.getInt(0)>=startIndex && cursor.getInt(0)<=lastIndex) {
                        ta=ta+cursor.getInt(1);
                        Log.d("ta", "searchRows: " + ta);
                        tc=tc+cursor.getInt(2);
                        Log.d("tc", "searchRows: " + tc);
                        ts=ts+cursor.getInt(3);
                        Log.d("ts", "searchRows: " + ts);
                    }
                }while(cursor.moveToNext());
            }

        }
        array[0]=ta;
        array[1]=tc;
        array[2]=ts;
        Log.d("Array", "searchRows: " + String.valueOf(array[0])+" " +String.valueOf(array[1])+" "+String.valueOf(array[2]));
        return array;
    }

}
