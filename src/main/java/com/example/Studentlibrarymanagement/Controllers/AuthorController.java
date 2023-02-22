package com.example.Studentlibrarymanagement.Controllers;

import com.example.Studentlibrarymanagement.DTOs.AuthorEntryDto;
import com.example.Studentlibrarymanagement.Models.Author;
import com.example.Studentlibrarymanagement.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add_author")
    public String createAuthor(@RequestBody AuthorEntryDto authorEntryDto){
        return authorService.createAuthor(authorEntryDto);
    }
}
