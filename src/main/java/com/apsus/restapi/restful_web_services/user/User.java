package com.apsus.restapi.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@JsonFilter(value = "UserFilter")
public class User {
	private Long id;

	@Size(min = 3, message = "Name should have at least 3 characters")
	private String name;
	@Email(message = "Invalid email address")
	private String email;
	@Size(min = 6, message = "Password should have at least 6 characters")
	//@JsonIgnore static filtering
	private String password;
	@Past(message = "Birthdate should be in the past")
	private LocalDate birthDate;

	public User(Long id, String name, String email, String password, LocalDate birthDate) {
		this.id = id;
		this.name = name;

		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
	}

	public User() {}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", name='" + name + '\'' +
			", email='" + email + '\'' +
			", password='" + password + '\'' +
			", birthDate=" + birthDate +
			'}';
	}
}
