package com.example.cktest;

public class SinhVien {
    public int Ma;
    public  String ten;
    public int getMa() {
        return Ma;
    }

    public void setMa(int ma) {
        Ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public SinhVien(int ma, String ten) {
        Ma = ma;
        this.ten = ten;
    }
    public String toString() {
        return getTen();
    }


}
