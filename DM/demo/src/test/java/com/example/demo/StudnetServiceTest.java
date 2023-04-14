package com.example.demo;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudnetServiceTest {

    @Test
    public void getEmptyList(){
        final StudnetService service = new StudnetService();
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }
    @Test
    public void addStudent()
    {
        final StudnetService service = new StudnetService();
        final Student created = service.addStudent(new NewStudent("Test1","1-4", "IPP"));
        assertNotNull(created);
    }
    @Test
    public void addStudentIsReturned()
    {
        final StudnetService service = new StudnetService();
        final Student created = service.addStudent(new NewStudent("Test1","1-4", "IPP"));
        final List<Student> all = service.getStudents();
        assertEquals(created.Name, all.head().Name);
    }
    @Test
    public void addStudentHasNewID()
    {
        final StudnetService service = new StudnetService();
        final Student created = service.addStudent(new NewStudent("Test1","1-4", "IPP"));
        final Student created2 = service.addStudent(new NewStudent("Test2","1-4", "IPP"));
        final List<Student> all = service.getStudents();
        assertEquals(2,service.getStudents().size());
    }

}