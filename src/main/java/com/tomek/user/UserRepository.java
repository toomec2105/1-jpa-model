package com.tomek.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	List<User> findByUsername(String username);

	User findByEmailAndPassword(String email, String password);

	List<User> findByUsernameContaining(String searchValue);

	List<User> findByUsernameBetween(String start, String end);

	List<User> findByRoleNot(String role);

}
