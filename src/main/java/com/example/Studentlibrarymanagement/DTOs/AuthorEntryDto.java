package com.example.Studentlibrarymanagement.DTOs;

//this is just an object that will be used to take request
//from postMan.
public class AuthorEntryDto {

    //it will contain the parameters that we want to send from postMan.

    //id is not here because we dont want to send it from postman
    private String name;
    private int age;
    private String country;
    private double rating;

    public AuthorEntryDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
