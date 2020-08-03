package com.tomek.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private UserRepository userRepository;

	@Test
	void givenId_deletesUser() {
		// arrange
		User user = new User("jeszcze@interia.pl", "polandia43", "ADMIN", "Czerwony6");
		Long id = testEntityManager.persistAndGetId(user, Long.class);

		// act -> The method under test
		userRepository.deleteById(id);

		// assert
		User deleted = testEntityManager.find(User.class, id);
		assertNull(deleted);
	}
}
