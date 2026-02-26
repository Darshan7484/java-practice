package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int marks;
    private String grade;

    public int getMarks(){ return marks; }
    public void setMarks(int m){ marks=m; }

    public String getName(){ return name; }
    public void setName(String n){ name=n; }

    public String getGrade(){ return grade; }
    public void setGrade(String g){ grade=g; }
} 