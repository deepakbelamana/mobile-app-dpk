package com.dpkprojects.app.ui.models.requestModels;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
    @NotNull
    @Size(message="first name cannot be less then 2 characters")
    private String firstname;
    @NotNull
    @Size(message="last name cannot be less then 2 characters")
    private String lastname;

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


}
