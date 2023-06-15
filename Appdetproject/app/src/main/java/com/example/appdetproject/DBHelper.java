package com.example.appdetproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Dbstudy.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table users(semail TEXT primary key, sname TEXT, susername TEXT, spass TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");

    }

    public Boolean insertData(String email, String name, String username, String pass) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("semail", email);
        contentValues.put("sname", name);
        contentValues.put("susername",username);
        contentValues.put("spass", pass);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        }else {
            return true;
        }
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where susername = ?", new String[] {username});
        if (cursor.getCount()> 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkUsernamePass(String username, String pass) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where susername = ? and spass = ?", new String[] {username, pass});
        if (cursor.getCount()> 0) {
            return true;
        }else {
            return false;
        }
    }
}
