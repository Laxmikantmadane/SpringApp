package com.MySpringBootapplication.MySpringBoot_Application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MySpringBootapplication.MySpringBoot_Application.Repository.CourseRepository;
import com.MySpringBootapplication.MySpringBoot_Application.entities.Course;

@Service
public class CourseService {
	private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
