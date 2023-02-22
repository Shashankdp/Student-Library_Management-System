package com.example.Studentlibrarymanagement.Repositories;

import com.example.Studentlibrarymanagement.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
