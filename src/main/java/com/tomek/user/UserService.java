package com.tomek.user;

import java.util.List;
import java.util.Optional;

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

	// -------- BASIC CRUD ---------
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User findById(Long id) {
		Optional<User> optUser = userRepository.findById(id);

		return optUser.orElseThrow(() -> new UserNotFoundException());
	}

	public List<User> findUsers() {
		return userRepository.findAll();
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	public void deleteAllUsers() {
		userRepository.deleteAllInBatch();
	}

	// --------- OTHER METHODS ----------
	
	
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

	public int findDisctinctNumberOfUserRolesNativeNATIVE() {

		return userRepository.getDisctinctNumberOfUserRolesNATIVE();
	}

	public User findByEmailAddressNATIVE(String email) {
		return userRepository.findByEmailAddressNATIVE(email);
	}

	public List<User> findUsersWitchMatchingPasswordNATIVE(String expression) {

		return userRepository.findByPasswordNATIVE(expression);
	}

	public User findByEmailAndNameJPQL(String email, String username) {

		return userRepository.getByEmailAndNameJPQL(email, username);
	}

	public List<User> findUsersWithMatcingEmailJPQL(String expression) {

		return userRepository.getUsersWithMatchingEmailJPQL(expression);
	}

}