package com.training.models;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author manan
 *
 */
public class User extends Person {

	private long id;
	

	private String username;
	private String password;
	private int deactivated;
	private int disabled;
	

	/**
	 * 
	 */
	public User() {
		super();
		
	}

	/**
	 * @param fullName
	 * @param email
	 * @param phoneNumber
	 * @param gender
	 * @param dateOfBirth
	 * @param address
	 * @param city
	 * @param state
	 * @param country
	 * @param company
	 * @param image
	 * @param username
	 * @param password
	 */
	public User(String fullName, String email, long phoneNumber, String gender, LocalDate dateOfBirth, String address,
			String city, String state, String country, String company, byte[] image, String username, String password) {
		super(fullName, email, phoneNumber, gender, dateOfBirth, address, city, state, country, company, image);
		this.username = username;
		this.password = password;
	}
	
	public User(String fullName, String email, long phoneNumber, String gender, LocalDate dateOfBirth, String address,
			String city, String state, String country, String company, byte[] image, String username, String password,
			int deactivated, int disabled) {
		super(fullName, email, phoneNumber, gender, dateOfBirth, address, city, state, country, company, image);
		this.username = username;
		this.password = password;
		this.deactivated = deactivated;
		this.disabled = disabled;
	}

	

	public User(String fullName, String email, long phoneNumber, String gender, LocalDate dateOfBirth, String address,
			String city, String state, String country, String company, byte[] image, String username,long id) {
		super(fullName, email, phoneNumber, gender, dateOfBirth, address, city, state, country, company, image);
		this.username = username;
		this.id=id;
	}
	
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	/**
	 * @return the deactivated
	 */
	public int getDeactivated() {
		return deactivated;
	}

	/**
	 * @param deactivated the deactivated to set
	 */
	public void setDeactivated(int deactivated) {
		this.deactivated = deactivated;
	}

	/**
	 * @return the disabled
	 */
	public int getDisabled() {
		return disabled;
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(username);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", deactivated=" + deactivated
				+ ", disabled=" + disabled + super.toString()+"]";
	}

	

	
	
	
	

	
}