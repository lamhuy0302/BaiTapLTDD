package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    private int id;

    public DB(@Nullable Context context) {
        super(context, "HuyDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db = getWritableDatabase();
        db.execSQL("create table SachDb (id int primary key, name nvarchar(50))");
    }
    //**
    public void addSach(Sach s){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",s.getId());
        cv.put("name",s.getTen());
        sqLiteDatabase.insert("SachDb",null,cv);
        sqLiteDatabase.close();
    }
    public void editSach(Sach s){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",s.getId());
        cv.put("name",s.getTen());
        sqLiteDatabase.update("SachDb",cv,"id="+Integer.toString(s.id),null);
        sqLiteDatabase.close();
    }
    public void removeSach(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

    }
    public ArrayList<Sach> getAllSach() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Sach> listItems = new ArrayList<Sach>();

        Cursor cursor = db.rawQuery("select * from SachDb",null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            Sach s = new Sach(id,ten);
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
