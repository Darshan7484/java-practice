package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepo repo;

    @PostMapping("/add")
    public Student add(@RequestBody Student s) {

        if (s.getMarks() >= 90) s.setGrade("A");
        else if (s.getMarks() >= 75) s.setGrade("B");
        else s.setGrade("C");

        return repo.save(s);
    }

    // ⭐ THIS IS REQUIRED FOR /student/all
    @GetMapping("/all")
    public List<Student> getAll(){
        return repo.findAll();
    }
}