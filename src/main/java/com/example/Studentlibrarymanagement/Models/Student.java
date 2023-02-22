package com.example.Studentlibrarymanagement.Models;

import javax.persistence.*;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // by using this annotation, id parameter it will auto increment(it will automatically keep on setting their values).
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String mobileNo;
    private int age;
    private String country;

    @OneToOne(mappedBy ="student",cascade = CascadeType.ALL)
    private Card card;

     /*
        Steps to find that variable
        1. Go the child class (In this case)
        2. Out of all the attributes select the foreign key attribute that is helping you connect
        with parent class
        (Ref :  @OneToOne
                @JoinColumn
                private Student studentVariableName;
        )
        3. Choose the variable name of the parentEnty (reference : studentVariableName)
     */

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Student() {
    }

    public Student(int id, String name, String email, String mobileNo, int age, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.age = age;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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
}
