package com.FBHelpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FBHelpdesk.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	boolean existsByEmail(String email);
	User getByEmail(String email);

}
