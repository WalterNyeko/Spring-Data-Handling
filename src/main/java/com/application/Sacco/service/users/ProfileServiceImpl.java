package com.application.Sacco.service.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Sacco.entity.users.Profile;
import com.application.Sacco.repository.company.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile addUserProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profileRepository.save(profile);
	}

	@Override
	public List<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		return profileRepository.findAll();
	}

	@Override
	public Profile getUserProfile(Integer profileId) {
		// TODO Auto-generated method stub
		return profileRepository.findById(profileId).orElse(null);
	}

	@Override
	public void deleteProfile(Integer profileId) {
		// TODO Auto-generated method stub
		profileRepository.deleteById(profileId);
	}

}
