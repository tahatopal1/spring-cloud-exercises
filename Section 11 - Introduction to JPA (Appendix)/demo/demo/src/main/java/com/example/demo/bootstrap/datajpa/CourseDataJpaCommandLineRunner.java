package com.example.demo.bootstrap.datajpa;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseDataJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseDataJpaRepository courseDataJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseDataJpaRepository.save(new Course(1, "AWS", "Udemy"));
        courseDataJpaRepository.save(new Course(2, "Azure", "YouTube"));
        courseDataJpaRepository.save(new Course(3, "Java", "Udemy"));

        courseDataJpaRepository.deleteById(1l);

        System.out.println(courseDataJpaRepository.findById(2l).get());
        System.out.println(courseDataJpaRepository.findById(3l).get());

        System.out.println(courseDataJpaRepository.findAll());
        System.out.println(courseDataJpaRepository.count());

        System.out.println(courseDataJpaRepository.findAllByAuthor("Udemy"));
        System.out.println(courseDataJpaRepository.findAllByAuthor(""));

        System.out.println(courseDataJpaRepository.findByName("Azure"));
    }
}
