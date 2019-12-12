package com.example.sqlite_listviewtest;

public class SinhVien {
    int id;
    String ten;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public SinhVien(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    public SinhVien(){

    }
}
