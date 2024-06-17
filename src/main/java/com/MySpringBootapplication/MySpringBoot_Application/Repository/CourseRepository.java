package com.MySpringBootapplication.MySpringBoot_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MySpringBootapplication.MySpringBoot_Application.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
