package com.tomek;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tomek.user.User;
import com.tomek.user.UserService;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	void whenDataLoadedFromFileAndCLRunner_returnsNoOfUsersCorrectly() {
		assertEquals(7, userService.getUsers().size());
	}

	@Test
	void findsUserByEmailCorrectly() {
		User user = userService.findByEmail("jennifer@onet.pl");
		assertEquals("Jennifer Smith", user.getUsername());
	}

	@Test
	void findsUsersByUsernameCorrectly() {
		assertEquals(1, userService.findByUsername("John Brown").size());
	}

	@Test
	void findsUserByEmailAndPasswordCorrectly() {
		User user = userService.findByEmailAndPassword("johnson@zoho.com", "john123");
		assertEquals("Ben Johnson", user.getUsername());
	}

	@Test
	void findsUsersContainingValueCorrectly() {
		assertEquals(3, userService.findByUsernameContaining("en").size());
	}

	@Test
	void findsUsersWithAdminRoleCorrectly() {
		assertEquals(4, userService.findByRoleNot("ADMIN").size());
	}

	@Test
	void findsUsersBetweenStartAndEndCorrectly() {
		assertEquals(3, userService.findByUsernameBetween("@", "D").size()); // characters are exclusive and to get
																				// names starting with A we have to use
																				// @
	}

}
