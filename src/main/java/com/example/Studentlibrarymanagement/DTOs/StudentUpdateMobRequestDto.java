package com.example.Studentlibrarymanagement.DTOs;

public class StudentUpdateMobRequestDto {

    private int id;
    private String mobileNo;

    //Dto's depend on the API's being called...add attributes as required.

    public StudentUpdateMobRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
