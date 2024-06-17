package com.MySpringBootapplication.MySpringBoot_Application.Controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.MySpringBootapplication.MySpringBoot_Application.entities.Course;
import com.MySpringBootapplication.MySpringBoot_Application.entities.User;
import com.MySpringBootapplication.MySpringBoot_Application.services.CourseService;
import com.MySpringBootapplication.MySpringBoot_Application.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
    private final CourseService courseService;

    public UserController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> browseCourses() {
        return courseService.findAll();
    }
    
    @PostMapping("/courses/{courseId}/purchase")
    public String purchaseCourse(@PathVariable Long courseId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        Course course = courseService.findById(courseId);
        user.getCourses().add(course);
        userService.save(user);
        return "Course purchased successfully";
    }

    @PutMapping("/profile")
    public User updateProfile(@RequestBody User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) auth.getPrincipal();
        currentUser.setEmail(user.getEmail());
        currentUser.setUsername(user.getUsername());
        return userService.save(currentUser);
    }

    @PutMapping("/profile/password")
    public User changePassword(@RequestBody String newPassword) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) auth.getPrincipal();
        currentUser.setPassword(newPassword);
        return userService.save(currentUser);
    }

    @PutMapping("/profile/picture")
    public User changeProfilePicture(@RequestBody String newPictureUrl) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) auth.getPrincipal();
        currentUser.setProfilePicture(newPictureUrl);
        return userService.save(currentUser);
    }
}
