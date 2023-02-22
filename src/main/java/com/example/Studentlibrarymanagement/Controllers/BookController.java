package com.example.Studentlibrarymanagement.Controllers;

import com.example.Studentlibrarymanagement.DTOs.BookRequestDto;
import com.example.Studentlibrarymanagement.Models.Book;
import com.example.Studentlibrarymanagement.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
//    @PostMapping("/add_book")
//    public String addBook(@RequestBody Book book){
//       return bookService.addBook(book);
//    }

    //DTO method,
    @PostMapping("/add_book")
    public String addBook(@RequestBody BookRequestDto bookRequestDto){
       return bookService.addBook(bookRequestDto);
    }
}
