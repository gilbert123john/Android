package com.example.databaseactivity_deptapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//class for dataBase
public class CDB  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="DMS";

    public CDB(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table TbDept (dno integer primary key autoincrement, dname text, dloc text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TbDept");
        onCreate(sqLiteDatabase);
    }
    public void addDept(String dn, String dl){
        try{
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("dname",dn);
            cv.put("dloc",dl);
            sqLiteDatabase.insert("TbDept",null,cv);
            sqLiteDatabase.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public String [] getOneDepartment(int dno){
        String a[] = new String[2];
        try{
           SQLiteDatabase sqLiteDatabase  = this.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.query(
                    "TbDept",new String[]{"dno","dname","dloc"},
                    "dno"+"+?", new String[]{String.valueOf(dno)},
                    null,null,null,null);
            if(cursor != null && cursor.getCount()!=0){
                cursor.moveToFirst();
                a[0]= cursor.getString(1);
                a[1]= cursor.getString(2);
            }
            else{
                a[0]="";
                a[1]="";
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return a;
    }
    public int deleteDept(int dno){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete("TbDept","dno =?", new String[]{String.valueOf(dno)});

    }
    public void update(int dno, String dn,String dl){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("dname",dn);
        values.put("dloc",dn);
        sqLiteDatabase.update("TbDept",values,"dno = ?",new String[]{String.valueOf(dno)});
        sqLiteDatabase.close();
    }

}
