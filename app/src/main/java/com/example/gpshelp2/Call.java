package com.example.gpshelp2;

public class Call {
    private String address, info;

    public Call(){}

    public Call(String address, String info) {
        this.address = address;
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address= address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
