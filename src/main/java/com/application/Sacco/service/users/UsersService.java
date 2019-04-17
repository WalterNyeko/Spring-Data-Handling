package com.application.Sacco.service.users;

import java.util.List;
import com.application.Sacco.entity.users.Users;

public interface UsersService {

	Users addUser(Users Users);
	
	Users updateUser(Users Users);
	
	List<Users> getAllUsers();
	
	Users getUser(Long userId);
	
	Users findByEmailAddress(String email);
	
	void deleteUser(Long userId);
}
