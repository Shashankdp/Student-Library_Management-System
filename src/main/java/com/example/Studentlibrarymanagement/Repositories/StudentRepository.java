package com.example.Studentlibrarymanagement.Repositories;

import com.example.Studentlibrarymanagement.Enums.CardStatus;
import com.example.Studentlibrarymanagement.Models.Card;
import com.example.Studentlibrarymanagement.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

    Student findByEmail(String email);
                                              //here i use Student and list as dataType, because we only get info in the form of object
                                              // and list.

//    List<Student> findByCountry(String country);

}
