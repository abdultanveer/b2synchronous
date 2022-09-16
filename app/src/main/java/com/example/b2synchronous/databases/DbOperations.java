package com.example.b2synchronous.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.b2synchronous.databases.FeedReaderContract.FeedEntry;
/**
 * this class contains all the operations that you can perform on a db
 */
public class DbOperations {
    DbHelper dbHelper;
    SQLiteDatabase database;

    public DbOperations(Context context){
        dbHelper = new DbHelper(context); //create a db - and a table
    }

    public void openDb(){
        database = dbHelper.getWritableDatabase();
    }
    public void closeDb(){
        database.close();
    }


    public void insertRow(String title, String subtitle){
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,subtitle);
        database.insert(FeedEntry.TABLE_NAME,null,values);
    }
    public void deleteRow(){}
    public void updateRow(){}
    public String readRow(){
       //Cursor cursor = database.rawQuery("select * from entry",null);
       Cursor cursor = database.query(FeedEntry.TABLE_NAME,null,null,null,null,null,null);
       cursor.moveToLast(); //point tothe last row that was inserted

        int titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE);
        int subtiteIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE);

        String title = cursor.getString(titleIndex);
        String subtitel = cursor.getString(subtiteIndex);


        return title +"\n"+subtitel;
    }





}
