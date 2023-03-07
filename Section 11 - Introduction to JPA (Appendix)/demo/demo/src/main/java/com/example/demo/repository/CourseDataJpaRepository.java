package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDataJpaRepository extends JpaRepository<Course, Long>{
    List<Course> findAllByAuthor(String author);

    Course findByName(String name);
}
