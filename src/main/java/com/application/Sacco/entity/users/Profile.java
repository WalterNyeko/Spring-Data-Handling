package com.application.Sacco.entity.users;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer profileId;
	private String phoneNumber;
	private String userAddress;
	private String userBio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Users users;
	
	public Profile() {}
	public Profile(String phoneNumber, String userAddress, String userBio) {
		super();
		this.phoneNumber = phoneNumber;
		this.userAddress = userAddress;
		this.userBio = userBio;
	}
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserBio() {
		return userBio;
	}
	public void setUserBio(String userBio) {
		this.userBio = userBio;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
}
