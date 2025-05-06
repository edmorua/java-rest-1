package com.apsus.restapi.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserDaoService userDaoService;

	public UserController(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}

	@GetMapping()
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		User userFound = userDaoService.findOne(id);
		if (userFound == null) {
			throw new UserNotFoundException("id: " + id);
		}
		return userFound;
	}

	@PostMapping()
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User saveUser = userDaoService.save(user);
		URI location =
			ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userDaoService.deleteById(id);
	}


}
