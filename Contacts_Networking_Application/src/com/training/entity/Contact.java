/**
 * 
 */
package com.training.entity;

import java.time.LocalDate;

/**
 * @author manan
 *
 */
public class Contact extends Person {

	/**
	 * 
	 */
	public Contact() {
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
	 */
	public Contact(String fullName, String email, long phoneNumber, String gender, LocalDate dateOfBirth,
			String address, String city, String state, String country, String company, byte[] image) {
		super(fullName, email, phoneNumber, gender, dateOfBirth, address, city, state, country, company, image);
	}

	/**
	 * @param fullName
	 * @param email
	 */
	public Contact(String fullName, String email) {
		super(fullName, email);
	}

}
