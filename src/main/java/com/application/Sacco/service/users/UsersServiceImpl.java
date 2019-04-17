package com.application.Sacco.service.users;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Sacco.entity.users.Users;
import com.application.Sacco.repository.users.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users addUser(Users Users) {
		// TODO Auto-generated method stub
		return usersRepository.save(Users);
	}

	@Override
	public Users updateUser(Users Users) {
		// TODO Auto-generated method stub
		return usersRepository.saveAndFlush(Users);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public Users getUser(Long userId) {
		// TODO Auto-generated method stub
		return usersRepository.findById(userId).orElse(null);
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(userId);
	}

	@Override
	public Users findByEmailAddress(String email) {
		// TODO Auto-generated method stub
		return usersRepository.findByEmail(email);
	}

}
