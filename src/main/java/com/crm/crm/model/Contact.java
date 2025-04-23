package com.crm.crm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue
    private Long Id;

    @NotBlank(message = "First name is required")
    private String FirstName;

    @NotBlank(message = "Last name is required")
    private String LastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String mail;

    public Contact() {}

    public Contact(String FirstName, String LastName, String mail) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.mail = mail;
    }
}
