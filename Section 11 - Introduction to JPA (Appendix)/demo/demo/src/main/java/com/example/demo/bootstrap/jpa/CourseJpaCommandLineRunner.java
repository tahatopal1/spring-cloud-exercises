package com.example.demo.bootstrap.jpa;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJpaRepository.insert(new Course(1, "AWS", "Udemy"));
        courseJpaRepository.insert(new Course(2, "Azure", "YouTube"));
        courseJpaRepository.insert(new Course(3, "Java", "Udemy"));

        courseJpaRepository.deleteById(1);

        System.out.println(courseJpaRepository.findById(2));
        System.out.println(courseJpaRepository.findById(3));
    }
}
