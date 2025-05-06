package com.apsus.restapi.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {

	static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1L, "Eduardo", "eduardo@test.com", "dummy",
			LocalDate.now().minusYears(30)));
		users.add(new User(2L, "Jean", "jea@test.com", "dummy1",
			LocalDate.now().minusYears(20).minusMonths(1)));
		users.add(new User(3L, "Maria", "maria@gmail.com", "dummy2",
			LocalDate.now().minusYears(25).minusDays(2)));
		users.add(new User(4L, "Sasha", "sasha@hotmail.com", "dummy3",
			LocalDate.now().minusYears(31).minusDays(1)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(Long id) {
		Optional<User> userFound = users.stream().filter(user -> user.getId().equals(id)).findFirst();
		return userFound.orElse(null);
	}

	public User save(User user) {
		Long id = (long) (users.size() + 1);
		user.setId(id);
		users.add(user);
		return user;
	}

	public void deleteById(Long id) {
		users.removeIf(user -> user.getId().equals(id));
	}
	//JPA/Hibernate/Database
	// findAll
	// save
	// findOne


}
