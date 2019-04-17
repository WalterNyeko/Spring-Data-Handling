package com.application.Sacco.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.Sacco.entity.users.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
