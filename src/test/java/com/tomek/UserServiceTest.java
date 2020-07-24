package com.tomek;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tomek.user.UserService;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@Test
	void whenDataLoadedFromFileAndCLRunner_returnsNoOfUsersCorrectly() {
		assertEquals(7, userService.getUsers().size());
	}

}
