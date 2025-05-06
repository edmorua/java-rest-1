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

	public UserJpaController(UserRepository userRepository) {
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
