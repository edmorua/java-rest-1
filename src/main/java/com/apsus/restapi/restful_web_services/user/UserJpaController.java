package com.apsus.restapi.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users-jpa")
public class UserJpaController {

	private final UserRepository userRepository;
	private final PostRepository postRepository;

	public UserJpaController(UserRepository userRepository, PostRepository postRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	@GetMapping()
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable Long id) {
		Optional<User> userFound = userRepository.findById(id);
		if (userFound.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}
		EntityModel<User> userEntityModel = EntityModel.of(userFound.get());
		WebMvcLinkBuilder link =
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		userEntityModel.add(link.withRel("all-users"));
		return userEntityModel;
	}

	@GetMapping("/{id}/posts")
	public List<Post> getUserPosts(@PathVariable Long id) {
		Optional<User> userFound = userRepository.findById(id);
		if (userFound.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}
		return userFound.get().getPosts();
	}

	@PostMapping("/{id}/posts")
	public ResponseEntity<Object> saveUserPost(@PathVariable Long id,
	                                           @Valid @RequestBody Post post) {
		Optional<User> userFound = userRepository.findById(id);
		if (userFound.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}
		post.setUser(userFound.get());
		Post savedPost = postRepository.save(post);

		URI location =
			ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PostMapping()
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		user.setId(null);
		User saveUser = userRepository.save(user);
		URI location =
			ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userRepository.deleteById(id);
	}


}
