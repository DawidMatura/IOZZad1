package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/punkty")
public class PunktyController {

    private final StudnetService service;


    public PunktyController(StudnetService service) {
        this.service = service;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET
                    , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Student> getStudents()
    {
        return this.service.getStudents().asJava();

    }
    @RequestMapping(value = "/students", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Student addUsers(@RequestBody NewStudent student)
    {
        return this.service.addStudent(student);
    }
}
