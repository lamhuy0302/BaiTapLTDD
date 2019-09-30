package com.example.gkapp;

public class Sinhvien {
    public Sinhvien(int pic, String ten) {
        this.pic = pic;
        this.ten = ten;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    private int pic;
    private String ten;

}
