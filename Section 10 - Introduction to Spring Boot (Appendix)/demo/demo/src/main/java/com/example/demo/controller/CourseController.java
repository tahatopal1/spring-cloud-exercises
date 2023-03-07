package com.example.demo.controller;

import com.example.demo.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    // /courses
    // Course: id, name, author
    @GetMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(new Course(1, "Learn AWS", "Udemy"),
                new Course(2, "Learn Devops", "YouTube"));
    }

}
