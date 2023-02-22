package com.example.Studentlibrarymanagement.Services;

import com.example.Studentlibrarymanagement.DTOs.BookRequestDto;
import com.example.Studentlibrarymanagement.Models.Author;
import com.example.Studentlibrarymanagement.Models.Book;
import com.example.Studentlibrarymanagement.Repositories.AuthorRepository;
import com.example.Studentlibrarymanagement.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

//    @Autowired
//    BookRepository bookRepository; // no need of this

    @Autowired
    AuthorRepository authorRepository;

//    public String addBook(Book book){
//
//        //I want to get the authorEntity
//        //thats why first i need authorId.
//        int authorId=book.getAuthor().getId();
//
//        //now i will be fetching the authorEntity
//        Author author=authorRepository.findById(authorId).get();
//
//        //Basic attributes are already set from postman
//
//        //setting the foreign key attribute in the child class
//        book.setAuthor(author);
//
//        //we need to update list of books written in the parent class
//
//        List<Book> currentBookWritten =author.getBooksWritten();
//        currentBookWritten.add(book);
//        author.setBooksWritten(currentBookWritten);
//
//        //Now the book is to be saved, but author is also be saved
//
//        //why do we need again save(updating) the author? bcz
//        //bcz the author entity has been updated(new book published by author above i store in list)..thats why we need to updated it.
//
//        authorRepository.save(author);
//
//        //.save function works as both : as save fuction and as update function
//
//
//        //bookRepository.save is not required : bcz it will be autocalled by cascadeing effect.
//
//        return "Book added successfully";
//
//
//    }

    public String addBook(BookRequestDto bookRequestDto){

        int authorId= bookRequestDto.getAuthorId();

        Author author=authorRepository.findById(authorId).get();

        Book book=new Book();

        //basic attributes are being set from DTO to the Entity layer
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false); // initialy it should be false.
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());

        book.setAuthor(author);

        List<Book> currentBookWritten =author.getBooksWritten();
        currentBookWritten.add(book);
        author.setBooksWritten(currentBookWritten);

        authorRepository.save(author);

        return "Book added successfully";
    }

}
