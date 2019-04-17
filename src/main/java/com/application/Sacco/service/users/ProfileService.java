package com.application.Sacco.service.users;

import java.util.List;

import com.application.Sacco.entity.users.Profile;

public interface ProfileService {
	
	Profile addUserProfile(Profile profile);
	
	List<Profile> getAllProfiles();
	
	Profile getUserProfile(Integer profileId);
	
	void deleteProfile(Integer profileId);

}
