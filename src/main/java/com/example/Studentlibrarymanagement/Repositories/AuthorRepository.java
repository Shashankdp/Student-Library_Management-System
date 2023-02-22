package com.example.Studentlibrarymanagement.Repositories;

import com.example.Studentlibrarymanagement.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
