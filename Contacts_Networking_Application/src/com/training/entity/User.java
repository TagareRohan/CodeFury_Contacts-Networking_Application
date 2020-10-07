/**
 * 
 */
package com.training.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author manan
 *
 */
public class User extends Person {

	private String username;
	private String password;
	
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
	

	
}
