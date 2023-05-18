package com.example.assignment.model;

import jakarta.persistence.*;

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

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNationalities() {
        return nationalities;
    }

    public void setNationalities(String nationalities) {
        this.nationalities = nationalities;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AcctState getState() {
        return state;
    }

    public void setState(AcctState state) {
        this.state = state;
    }

    public User(String id, String firstName, String lastName, String username, String email, String password, String profilePhoto, String gender, String age, MaritalStatus maritalStatus, String nationalities, String dateOfBirth, AcctState state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePhoto = profilePhoto;
        this.gender = gender;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.nationalities = nationalities;
        this.dateOfBirth = dateOfBirth;
        this.state = state;
    }
}
