package com.example.assignment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "profilePhoto")
    private String profilePhoto;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private String age;

    @Enumerated(EnumType.ORDINAL)
    private MaritalStatus maritalStatus;

    @Column(name = "nationalities")
    private String nationalities;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Enumerated(EnumType.ORDINAL)
    private AcctState state;

}
