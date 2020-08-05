package com.tomek.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	/*
	 * @Autowired private UserRepository userRepository;
	 */

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User findByEmail(String email) {
		User found = userRepository.findByEmail(email);

		// do stuff with found
		// ...

		return found;
	}

	public List<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public List<User> findByUsernameContaining(String searchValue) {
		List<User> users = userRepository.findByUsernameContaining(searchValue);

		// do stuff

		return users;
	}

	public List<User> findByUsernameBetween(String start, String end) {
		return userRepository.findByUsernameBetween(start, end);
	}

	public List<User> findByRoleNot(String role) {

		return userRepository.findByRoleNot(role);
	}

	public int getDisctinctNumberOfUserRolesNativeNATIVE() {

		return userRepository.getDisctinctNumberOfUserRolesNATIVE();
	}

	public User findByEmailAddressNATIVE(String email) {
		return userRepository.findByEmailAddressNATIVE(email);
	}

	public List<User> getUsersWitchMatchingPasswordNATIVE(String expression) {

		return userRepository.findByPasswordNATIVE(expression);
	}

	public User getithEmailAndNameJPQL(String email, String username) {

		return userRepository.getithEmailAndNameJPQL(email, username);
	}

	public List<User> getUsersWithMatcingEmailJPQL(String expression) {

		return userRepository.getUsersWithMatchingEmailJPQL(expression);
	}
}