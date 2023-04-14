package com.example.demo;


import io.vavr.collection.List;
import org.springframework.web.bind.annotation.RequestBody;

public class StudnetService {
    private List<Student> students = List.empty();

    List<Student> getStudents(){
        return students;
    }
    Student addStudent(@RequestBody NewStudent student)
    {
        Student created = new Student(students.size() + 1, student.Name, student.grupa, student.number);
        students = students.prepend(created);
        return created;
    }
}
