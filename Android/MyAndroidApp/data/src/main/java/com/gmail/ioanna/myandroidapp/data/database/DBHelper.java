package com.gmail.ioanna.myandroidapp.data.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "test";
    private static final int VERSION = 0;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("DBHelper", "onCreate()");

        //db.beginTransaction();

        //db.endTransaction();

        db.execSQL("CREAT TABLE user ('id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                "'name' TEXT, 'age' INTEGER, 'countryId' INTEGER)");

        db.execSQL("CREAT TABLE COUNTRY ('id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                "'name' TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.e("DBHelper", "onUpgrade()");

    }
}
