package com.example.Studentlibrarymanagement.Repositories;

import com.example.Studentlibrarymanagement.Enums.CardStatus;
import com.example.Studentlibrarymanagement.Models.Card;
import com.example.Studentlibrarymanagement.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{


}
