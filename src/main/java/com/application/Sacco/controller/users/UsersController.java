package com.application.Sacco.controller.users;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.Sacco.entity.company.Company;
import com.application.Sacco.entity.users.Users;
import com.application.Sacco.exception.users.UserNotFoundException;
import com.application.Sacco.service.company.CompanyService;
import com.application.Sacco.service.users.UsersService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(value = "api/v1/auth/")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private CompanyService companyService;

	@GetMapping(value = "users")
	public List<Users> showUsers() {
		return usersService.getAllUsers();
	}

	@PostMapping("users/{company_id}")
	public Users saveToDatabase(@RequestBody Users Users, @PathVariable(name = "company_id") Long companyId) {
		Company company = companyService.getCompany(companyId);
		Users.setCompany(company);
		return usersService.addUser(Users);
	}

	@PutMapping("users/{user_id}")
	public ResponseEntity<Users> updateUsersInfo(@Valid @PathVariable(name = "user_id") Long userId,
			@RequestBody Users Users) {
		Users user = usersService.getUser(userId);
		if (user == null) {
			throw new UserNotFoundException("User is not found");
		} else {
			user.setFirstName(Users.getFirstName());
			user.setLastName(Users.getLastName());
			user.setEmail(Users.getEmail());
			user.setUsername(Users.getUsername());
			user.setPassword(Users.getPassword());
			usersService.updateUser(user);
			return ResponseEntity.ok().body(user);
		}
	}

	@GetMapping("users/{user_id}")
	public ResponseEntity<Users> getUserById(@PathVariable(name = "user_id") Long userId) {
		Users user = usersService.getUser(userId);
		if (user == null) {
			throw new UserNotFoundException("User is not found");
		} else {
			return ResponseEntity.ok().body(user);
		}
	}

	@DeleteMapping("/users/{user_id}")
	public void deleteUser(@PathVariable(name = "user_id") Long userId) {
		usersService.deleteUser(userId);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Users login) throws ServletException {

		String jwtToken = "";

		if (login.getEmail() == null || login.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String email = login.getEmail();
		String password = login.getPassword();

		Users user = usersService.findByEmailAddress(email);

		if (user == null) {
			throw new ServletException("User email not found.");
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your username and password.");
		}

		jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		return jwtToken;
	}

}
