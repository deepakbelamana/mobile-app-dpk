package com.dpkprojects.app.ui.models.requestModels;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class 	UserDetailsRequestModel {
	@NotNull
	private String firstname;
	@NotNull
	private String lastname;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Size(min = 8,max = 16,message = "password should be equal to or more than 8 character" +
			" and should be less than 16")
	private String password;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
}
