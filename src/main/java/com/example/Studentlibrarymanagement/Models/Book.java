package com.example.Studentlibrarymanagement.Models;

import com.example.Studentlibrarymanagement.Enums.Genre;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pages;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private boolean issued;

    @ManyToOne
    @JoinColumn
    private Author author;


    //book is a child w.r.t card.now we connect book to card, beacuase without card.. book will doesnt exist.
    @ManyToOne
    @JoinColumn
    private Card card;


    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transactions> transactions;  //  =new ArrayList<>();// you initialise here also, if you not initialised it spring will initialising automatically.

    public Book() {
    }

    public Book(int id, String name, int pages, Genre genre, Author author) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.genre = genre;
        this.author = author;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
