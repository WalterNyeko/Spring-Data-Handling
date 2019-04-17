package com.application.Sacco;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.application.Sacco.entity.users.Users;
import com.application.Sacco.repository.users.UsersRepository;
import com.application.Sacco.service.users.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
	
	@Autowired
	private UsersService usersService;
	
	@MockBean
	private UsersRepository usersRepository;
	
//	@Test
//	public void getUsersTest() {
//		when(usersRepository.findAll()).thenReturn(Stream
//		.of(new Users(123, "Walter", "Walter", "Nyeko", "nyekowalter69@gmail.com", "walter123@Andela!"),
//			new Users(134, "Walter", "Walter", "Nyeko", "nyekowalter69@gmail.com", "walter123@Andela!"))
//		.collect(Collectors.toList()));
//		assertEquals(2, usersService.getAllUsers().size());
//	}
//	
//	
//	@Test
//	public void saveUserTest() {
//		Users user = new Users(12,"Walter", "Walter", "Nyeko", "nyekowalter69@gmail.com", "walter123@Andela!");
//		when(usersRepository.save(user)).thenReturn(user);
//		assertEquals(user, usersService.addUser(user));
//	}
//	
//	@Test
//	public void updateUserTest() {
//		Users user = new Users(12,"Walter", "Walter", "Nyeko", "nyekowalter69@gmail.com", "walter123@Andela!");
//		when(usersRepository.saveAndFlush(user)).thenReturn(user);
//		assertEquals(user, usersService.updateUser(user));
//	}
	
}
