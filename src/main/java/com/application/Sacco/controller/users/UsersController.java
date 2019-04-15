package com.application.Sacco.controller.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Sacco.entity.users.UsersEntity;
import com.application.Sacco.service.users.UsersService;

@RestController
@RequestMapping(value="api/v1/")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping(value="users")
	public List<UsersEntity> showUsers() {
		return usersService.getAllUsers();
	}
	
	@PostMapping("users")
	public UsersEntity saveToDatabase(@RequestBody UsersEntity usersEntity) {
		return usersService.addUser(usersEntity);
	}

	@PutMapping("users")
	public UsersEntity updateUsersInfo(@RequestBody UsersEntity usersEntity) {
		return usersService.updateUser(usersEntity);
	}
	
	@GetMapping("users/{user_id}")
	public Optional<UsersEntity> getUserById(@PathVariable(name = "user_id") Long userId) {
		return usersService.getUser(userId);
	}
	
	@DeleteMapping("/users/{user_id}")
	public void deleteUser(@PathVariable(name = "user_id") Long userId) {
		usersService.deleteUser(userId);
	}
	
	
}
