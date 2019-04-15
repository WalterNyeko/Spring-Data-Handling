package com.application.Sacco.service.users;

import java.util.List;
import java.util.Optional;

import com.application.Sacco.entity.users.UsersEntity;

public interface UsersService {

	UsersEntity addUser(UsersEntity usersEntity);
	
	UsersEntity updateUser(UsersEntity usersEntity);
	
	List<UsersEntity> getAllUsers();
	
	Optional<UsersEntity> getUser(Long userId);
	
	void deleteUser(Long userId);
}
