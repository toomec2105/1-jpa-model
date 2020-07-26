package com.tomek.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public List<User> findByUsernameContaining(String searchValue) {
		return userRepository.findByUsernameContaining(searchValue);
	}

	public List<User> findByUsernameBetween(String start, String end) {
		return userRepository.findByUsernameBetween(start, end);
	}

	public List<User> findByRoleNot(String role) {

		return userRepository.findByRoleNot(role);
	}

	public int getDisctinctNumberOfUserRolesNative() {

		return userRepository.getDisctinctNumberOfUserRolesNative();
	}

	public User findByEmailAddress(String email) {
		return userRepository.findByEmailAddress(email);
	}

	public List<User> getUsersWitchMatchingPassword(String expression) {

		return userRepository.findByPassword(expression);
	}
}