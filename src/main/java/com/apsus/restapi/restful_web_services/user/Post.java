package com.apsus.restapi.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;


	@Size(min = 3, message = "Title should have at least 3 characters")
	private String title;

	@Size(min = 8, message = "Description should have at least 8 characters")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Post() {}

	public Post(Long id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post{" +
			"id=" + id +
			", title='" + title + '\'' +
			", description='" + description + '\'' +
			'}';
	}
}
