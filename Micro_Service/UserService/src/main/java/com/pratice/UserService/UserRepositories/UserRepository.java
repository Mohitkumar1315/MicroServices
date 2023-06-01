package com.pratice.UserService.UserRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratice.UserService.Entities.User;

public interface UserRepository extends JpaRepository<User, String>
{
	
}
