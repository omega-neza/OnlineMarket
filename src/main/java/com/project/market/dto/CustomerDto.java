package com.project.market.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CustomerDto {
    private Long id;

    @NotBlank(message = "Names are required")
    @Size(min = 2, max = 50, message = "Names must be between 2 and 50 characters")
    private String names;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Address is required")
    @Size(min = 10, message = "Address must be at least 10 characters")
    private String address;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String names, String email, String password, String address) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
