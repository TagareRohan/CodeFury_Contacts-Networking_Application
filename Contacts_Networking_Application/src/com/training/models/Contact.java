package com.training.models;

import java.time.LocalDate;

public class Contact extends Person {
	
	private long userId;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String fullName, String email, long phoneNumber, String gender, LocalDate dateOfBirth,
			String address, String city, String state, String country, String company, byte[] image) {
		super(fullName, email, phoneNumber, gender, dateOfBirth, address, city, state, country, company, image);
		// TODO Auto-generated constructor stub
	}

	public Contact(String fullName, String email) {
		super(fullName, email);
		// TODO Auto-generated constructor stub
	}

	public Contact(long userId) {
		super();
		this.userId = userId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		Contact other = (Contact) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [userId=" + userId + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
