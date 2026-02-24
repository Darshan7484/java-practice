CREATE DATABASE school;

USE school;

CREATE TABLE students(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    marks INT,
    grade VARCHAR(5)
);