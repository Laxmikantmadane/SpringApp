package com.MySpringBootapplication.MySpringBoot_Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MySpringBootapplication.MySpringBoot_Application.entities.Course;
import com.MySpringBootapplication.MySpringBoot_Application.services.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @PutMapping("courses/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        return courseService.save(course);
    }

    @DeleteMapping("courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }
}
