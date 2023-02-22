package com.example.Studentlibrarymanagement.Controllers;

import com.example.Studentlibrarymanagement.DTOs.StudentUpdateMobRequestDto;
import com.example.Studentlibrarymanagement.Models.Student;
import com.example.Studentlibrarymanagement.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/get_name")
    public String findByEmail(@RequestParam("email") String email){
        return studentService.findByEmail(email);
    }

//    @PutMapping("/update_mobNo")
//    public String updateMobileNo(@RequestBody Student student){
//        return studentService.updateMobNo(student);
//    }

    //using DTO,
    @PutMapping("/update_mobNo")
    public String updateMobileNo(@RequestBody StudentUpdateMobRequestDto studentUpdateMobRequestDto){
        return studentService.updateMobNo(studentUpdateMobRequestDto);
    }














//    @GetMapping("/get_student")
//    public List<Student> findByCountry(@RequestParam("country") String country){
//        return studentService.findByCountry(country);
//    }

}
