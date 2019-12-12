package com.example.cktest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbContext extends SQLiteOpenHelper {
    public DbContext(@Nullable Context context) {
        super(context, "HuyDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db = this.getWritableDatabase();
        db.execSQL("create table if not exists SinhVien (id int primary key, name nvarchar(50))");
    }
    //**
    public void addSach(SinhVien s){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",s.getMa());
        cv.put("name",s.getTen());
        sqLiteDatabase.insert("SinhVien",null,cv);
        sqLiteDatabase.close();
    }
    public void editSach(SinhVien s){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",s.getMa());
        cv.put("name",s.getTen());
        sqLiteDatabase.update("SinhVien",cv,"id="+Integer.toString(s.Ma),null);
        sqLiteDatabase.close();
    }
    public void removeSach(SinhVien s){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",s.getMa());
        cv.put("name",s.getTen());
        sqLiteDatabase.delete("SinhVien", "id="+Integer.toString(s.Ma),null);
        sqLiteDatabase.close();
    }
    public ArrayList<SinhVien> getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<SinhVien> listItems = new ArrayList<SinhVien>();

        Cursor cursor = db.rawQuery("select * from SinhVien",null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            SinhVien s = new SinhVien(id,ten);
            listItems.add(s);
        }
        return listItems;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists SachDb");
        onCreate(sqLiteDatabase);
    }
}

