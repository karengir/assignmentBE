package com.example.assignment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "username")
    private String username;

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

//    @Column(unique = true)
//    private String email;

    @Column(name = "email")
    private String email;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private UserProfile userProfile;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private AcctState state;

    @Column(name = "isEnabled")
    private boolean isEnabled=false;

    @Column(name = "role")
    private String role;
    public User() {
    }

    public User(Long id, String firstName, String lastName, String username, String email, String password, AcctState state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.state = state;
    }
}
