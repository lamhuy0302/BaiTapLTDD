package com.example.sqlite_listviewtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Data extends SQLiteOpenHelper {
    public Data(@Nullable Context context) {
        super(context, "HuyDb.sqlite", null, 1);
    }
    public void create(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("create table Abc(id int,ten nvarchar(20))");
        db.execSQL("insert into ABC values(1,'abc')");

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //sqLiteDatabase = getWritableDatabase();
//sqLiteDatabase.execSQL("create table SachDb123 (id Integer primary key autoincrement, name nvarchar(50))");
    }


    public  void Add(){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",1);
        contentValues.put("name","Huy");
        sqLiteDatabase.insert("SachDb123",null,contentValues);
        sqLiteDatabase.close();
    }
    public void Edit(SinhVien sinhVien){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",sinhVien.getId());
        contentValues.put("ten",sinhVien.getTen());
        sqLiteDatabase.update("Sv",contentValues,"id="+Integer.toString(sinhVien.id),null);
        sqLiteDatabase.close();
    }
    public void  Remove(int id){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        sqLiteDatabase.delete("Sv","id="+Integer.toString(id),null);
        sqLiteDatabase.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Sv");
        onCreate(sqLiteDatabase);
    }
}
