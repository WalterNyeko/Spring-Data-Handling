package com.application.Sacco.controller.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Sacco.entity.users.Profile;
import com.application.Sacco.entity.users.Users;
import com.application.Sacco.service.users.ProfileService;
import com.application.Sacco.service.users.UsersService;

@RestController
@RequestMapping("/api/v1/")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private UsersService usersService;

	@GetMapping("profiles")
	public List<Profile> getAllProfiles() {
		return profileService.getAllProfiles();
	}

	@GetMapping("profile/{profile_id}")
	public Profile getProfileById(@PathVariable(name = "profile_id") Integer profileId) {
		return profileService.getUserProfile(profileId);
	}

	@DeleteMapping("profile/{profile_id}")
	public void deleteUserProfile(@PathVariable(name = "profile_id") Integer profileId) {
		profileService.deleteProfile(profileId);
	}

	@PostMapping("profile/{user_id}")
	public Profile addUserProfile(@RequestBody Profile profile, @PathVariable(name = "user_id") Long userId) {
		Users user = usersService.getUser(userId);
		Profile userProfile = new Profile();
		userProfile.setPhoneNumber(profile.getPhoneNumber());
		userProfile.setUserAddress(profile.getUserAddress());
		userProfile.setUserBio(profile.getUserBio());
		userProfile.setUsers(user);
		return profileService.addUserProfile(userProfile);
	}
}
