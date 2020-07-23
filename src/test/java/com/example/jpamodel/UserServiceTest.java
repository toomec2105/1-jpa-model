package com.example.jpamodel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
@Autowired
UserService userService;
	@Test
	void test() {
		assertEquals(3, userService.getUsers().size());
	}

}
