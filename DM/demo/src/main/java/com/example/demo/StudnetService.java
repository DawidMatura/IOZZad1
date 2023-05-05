package com.example.demo;


import com.example.demo.db.StudentRepository;
import com.example.demo.db.StudentRow;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StudnetService {
    private final StudentRepository repository;

    public StudnetService(StudentRepository repo) {
        this.repository = repo;
    }


    List<Student> getStudents(){
        return List.ofAll(this.repository.findAll())
                .map(dbObj->
                        new Student(
                                dbObj.getId(),
                                dbObj.getName(),
                                dbObj.getNumber(),
                                dbObj.getGroup1())
                );
    }
    private Function<StudentRow, Student> getStudentRowStudentFunction() {
        return dbObj->
                new Student(
                        dbObj.getId(),
                        dbObj.getName(),
                        dbObj.getNumber(),
                        dbObj.getGroup1());
    }
    Student addStudent(final NewStudent student)
    {

        return getStudentRowStudentFunction().apply(this.repository.save(new StudentRow(
                student.Name,
                student.number,
                student.grupa)));

    }
}
