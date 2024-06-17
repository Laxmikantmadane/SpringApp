package com.MySpringBootapplication.MySpringBoot_Application.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user_courses")
public class Course {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double price;

    @ManyToMany(mappedBy = "courses")
    private Set<User> users = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Course(Long id, String title, String description, double price, Set<User> users) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.users = users;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", users=" + users + "]";
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
