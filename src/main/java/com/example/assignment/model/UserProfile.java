//package com.example.assignment.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class UserProfile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "profilePhoto")
//    private String profilePhoto;
//
//    @Column(name = "gender")
//    private String gender;
//
//    @Column(name = "age")
//    private String age;
//
//    @Enumerated(EnumType.ORDINAL)
//    private MaritalStatus maritalStatus;
//
//    @Column(name = "nationalities")
//    private String nationalities;
//
//    @Column(name = "dateOfBirth")
//    private String dateOfBirth;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "email")
//    private User user;
//}
