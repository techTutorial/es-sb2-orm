package com.es.sb.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class UserEntity {

	@Id
	@Column(name="ID_USER")
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="FIRSTNAME_USER")
	private String firstName;
	
	@Column(name="LASTNAME_USER")
	private String lastName;
	
	@Column(name="EMAIL_USER")
	private String email;
	
	@Column(name="PASSWORD_USER")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName 
				+ ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
