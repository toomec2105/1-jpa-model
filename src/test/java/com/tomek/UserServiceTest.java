package com.tomek;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
	void givenEmailAndPassword_findsUser() {
		// arrange given
		String password = "john123";
		String email = "johnson@zoho.com";

		// act when
		User user = userService.findByEmailAndPassword(email, password);

		// assert then
		assertEquals("Ben Johnson", user.getUsername());
	}

	@Test
	void givenExpression_findsUsersWithMatchingUsername() {
		// given
		String expression = "en";

		// when
		List<User> users = userService.findByUsernameContaining(expression);

		// then
		assertEquals(3, users.size());
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

	// -----------------------Spring-Data native sql-----------------

	@Test
	void givenUsersWithRoles_returnsNoOfRoles() {
		assertEquals(2, userService.getDisctinctNumberOfUserRolesNativeNATIVE());
	}

	@Test
	void givenEmail_findsUserWithMatchingEmail() {
		String email = "caren@onet.pl";
		User user = userService.findByEmailAddressNATIVE(email);

		assertEquals(email, user.getEmail());
	}
	
	@Test
	void givenExpression_findsUsersWithMatchingPassword() {
		String expression = "3";
		List<User> users = userService.getUsersWitchMatchingPasswordNATIVE(expression);

		assertEquals(3, users.size());
	}
	// -----------------------Spring-Data jpql queries----------------------------
	@Test
	void givenUsernameAndEmail_findsMatchingUser() {
		String email = "alice.white@gmail.com";
		String username = "Alice White";
		
		User user = userService.getithEmailAndNameJPQL(email, username);

		assertEquals(2, user.getId());
	}
	
	@Test
	void givenExpression_findsUsersWithMatchingEmails() {
		String expression =  "onet.pl";
		
		
		List<User> users = userService.getUsersWithMatcingEmailJPQL(expression);

		assertEquals(2, users.size());
	}
	
}
