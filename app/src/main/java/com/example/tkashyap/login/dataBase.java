package com.example.tkashyap.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.wifi.aware.PublishConfig;

/**
 * Created by TARUN KASHYAP on 10/25/2017.
 */

public class dataBase extends SQLiteOpenHelper {
    public static final String DataBase_Name = "ACCOUNT.db";
    public static final String Table_Name = "ACCOUNTS";
    public dataBase(Context context) {
        super(context, DataBase_Name,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+Table_Name +"(USERNAME TEXT,PASSWORD TEXT NOT NULL unique,ID INTEGER PRIMARY KEY AUTOINCREMENT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Table_Name);
    }
    public  boolean insertData(String user,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME",user);
        contentValues.put("PASSWORD",pass);
        long result = db.insert(Table_Name,null,contentValues);
        db.close();
        if(result==-1)
            return false;
        return true;
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+Table_Name,null);
        return res;
    }
}
