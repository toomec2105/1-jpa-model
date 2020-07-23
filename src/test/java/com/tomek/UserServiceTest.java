package com.tomek;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@Test
	void test() {
		assertEquals(1, userService.getUsers().size());
	}

}
