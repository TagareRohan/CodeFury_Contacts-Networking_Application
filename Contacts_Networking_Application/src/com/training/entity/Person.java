/**
 * 
 */
package com.training.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author manan
 *
 */
public class Person {

	private String fullName;
	private String email;
	private long phoneNumber;
	private String gender;
	private LocalDate dateOfBirth;
	private String Address;
	private String city;
	private String State;
	private String country;
	private String company;
	private byte[] image;
	
	/**
	 * 
	 */
	public Person() {
		super();
		
	}
	
	/**
	 * @param fullName
	 * @param email
	 */
	public Person(String fullName, String email) {
		super();
		this.fullName = fullName;
		this.email = email;
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
	public Person(String fullName, String email, long phoneNumber, String gender, LocalDate dateOfBirth, String address,
			String city, String state, String country, String company, byte[] image) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		Address = address;
		this.city = city;
		State = state;
		this.country = country;
		this.company = company;
		this.image = image;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		State = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + Objects.hash(Address, State, city, company, country, dateOfBirth, email, fullName,
				gender, phoneNumber);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(Address, other.Address) && Objects.equals(State, other.State)
				&& Objects.equals(city, other.city) && Objects.equals(company, other.company)
				&& Objects.equals(country, other.country) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(gender, other.gender) && Arrays.equals(image, other.image)
				&& phoneNumber == other.phoneNumber;
	}
	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", Address=" + Address + ", city=" + city + ", State="
				+ State + ", country=" + country + ", company=" + company + ", image=" + Arrays.toString(image) + "]";
	}
	
	
}
