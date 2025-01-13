package com.adrive.ADrive.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {

    @Id
    private int id;
    private String username;
    private String password;
    @Lob // This annotation tells JPA to store the field as a BLOB
    @Column(name = "profilePic", columnDefinition = "BLOB")
    private byte[] profilePic;
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private String email;
}
