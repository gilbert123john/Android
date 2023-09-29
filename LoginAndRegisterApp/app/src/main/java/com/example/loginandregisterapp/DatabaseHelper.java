package com.example.loginandregisterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "MyApp.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "MyApp.db", null  , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("CREATE TABLE regusers(phone TEXT primary key,userName TEXT,address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("DROP TABLE if exists regusers");
    }
    public void updatePassword(String phoneNo,String uName,String newUserName){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        String query = "UPDATE regusers SET userName = "+newUserName+" WHERE phone = "+phoneNo+" AND userName = "+uName;
        MyDatabase.execSQL(query);
    }
    public Boolean insertData(String phone,String userName,String address){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone",phone);
        contentValues.put("userName",userName);
        contentValues.put("address",address);
        long result = myDatabase.insert("regusers",null,contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkPhone(String phone){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from regusers where phone = ?",new String[]{phone});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkPhoneName(String phone,String userName){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from regusers where phone = ? and userName = ? ",new String[]{phone,userName});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
}
