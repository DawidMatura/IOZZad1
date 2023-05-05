package com.example.demo;

import com.example.demo.db.StudentRepository;
import io.vavr.collection.List;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class StudnetServiceTest {

    @Autowired
    private StudentRepository repository;

    @Test
    public void getEmptyList(){
        final StudnetService service = new StudnetService(repository);
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }
    @Test
    public void addStudent()
    {
        final StudnetService service = new StudnetService(repository);
        final Student created = service.addStudent(new NewStudent("Test1","1-4", "IPP"));
        assertNotNull(created);
    }
    @Test
    public void addStudentIsReturned()
    {
        final StudnetService service = new StudnetService(repository);
        final Student created = service.addStudent(new NewStudent("Test1","1-4", "IPP"));
        final List<Student> all = service.getStudents();
        assertEquals(created.Name, all.head().Name);
    }
    @Test
    public void addStudentHasNewID()
    {
        final StudnetService service = new StudnetService(repository);
        final Student created = service.addStudent(new NewStudent("Test1","1-4", "IPP"));
        final Student created2 = service.addStudent(new NewStudent("Test2","1-4", "IPP"));
        final List<Student> all = service.getStudents();
        assertEquals(2,service.getStudents().size());
    }
    @After
    public void cleanAfterTest() {
        this.repository.deleteAll();
    }

}