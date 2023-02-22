package com.example.Studentlibrarymanagement.Models;

import com.example.Studentlibrarymanagement.Enums.CardStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Card")
public class Card {


    //plan is to save this card in db.
    //Before saving I have to set its attributes : rule 1
    // rule 2 : please fallow rule 1.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // its auto generated.
    @CreationTimestamp // Auto timestamp the time when an entry is created.
    private Date createdOn;  //Its auto generated
    @UpdateTimestamp //sets time when an entry is updated.
    private Date updatedOn;   //Its auto generated.

    @Enumerated(value=EnumType.STRING)
    private CardStatus cardStatus;  //set this attribute

    @OneToOne
    @JoinColumn
    private Student student;           // this variable is used in the parent class //while doing the bidirectional mapping.

    //connecting the card class to the transaction
    //Bidirectional Mapping
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transactions> transactions=new ArrayList<>(); // =new ArrayList<>() not mandatory

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public List<Book> getBookIssued() {
        return bookIssued;
    }

    public void setBookIssued(List<Book> bookIssued) {
        this.bookIssued = bookIssued;
    }

    //card is a parent w.r.t book
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> bookIssued;


    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Card() {
    }

    public Card(int id, Date createdOn, Date updatedOn) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
