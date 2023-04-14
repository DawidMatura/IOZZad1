package com.example.demo;

import ch.qos.logback.core.util.COWArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController()
@RequestMapping("/punkty")
public class PunktyController {

    private StudnetService service = new StudnetService();

    public PunktyController() {
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
