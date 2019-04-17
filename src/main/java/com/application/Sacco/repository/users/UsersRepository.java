package com.application.Sacco.repository.users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.Sacco.entity.users.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	 Users findByEmail(String email);
}
