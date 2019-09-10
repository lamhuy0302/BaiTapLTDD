package com.example.bt;

public class Contact {
    private int ava;
    private String name;
    private String phoneNumber;

    public Contact(int ava, String name, String phoneNumber){
        this.ava = ava;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getAva() {
        return ava;
    }

    public void setAva(int ava) {
        this.ava = ava;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumbet() {
        return phoneNumber;
    }

    public void setPhoneNumbet(String phoneNumbet) {
        this.phoneNumber = phoneNumbet;
    }
}
