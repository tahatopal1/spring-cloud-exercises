package com.example.demo.bootstrap.jdbc;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "AWS", "Udemy"));
        courseJdbcRepository.insert(new Course(2, "Azure", "YouTube"));
        courseJdbcRepository.insert(new Course(3, "Java", "Udemy"));

        courseJdbcRepository.deleteById(1);

        System.out.println(courseJdbcRepository.findById(2));
        System.out.println(courseJdbcRepository.findById(3));
    }
}
