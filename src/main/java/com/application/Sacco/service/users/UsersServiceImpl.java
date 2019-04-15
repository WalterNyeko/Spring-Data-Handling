package com.application.Sacco.service.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Sacco.entity.users.UsersEntity;
import com.application.Sacco.repository.users.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UsersEntity addUser(UsersEntity usersEntity) {
		// TODO Auto-generated method stub
		return usersRepository.save(usersEntity);
	}

	@Override
	public UsersEntity updateUser(UsersEntity usersEntity) {
		// TODO Auto-generated method stub
		return usersRepository.saveAndFlush(usersEntity);
	}

	@Override
	public List<UsersEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public Optional<UsersEntity> getUser(Long userId) {
		// TODO Auto-generated method stub
		return usersRepository.findById(userId);
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(userId);
	}

}
