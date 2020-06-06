package com.company.entity;

import java.sql.Date;
import java.util.List;

public class User {
    private Integer id;

    private String name;

    private String surname;

    private String email;

    private transient String password;

    private String number;

    private String profileDescription;

    private String address;

    private Date birthDate;

    private Country nationality;

    private Country birthPlace;

    private List<UserSkill> skills;

    public User() {
    }

    public User(Integer id, String name, String surname, String email, String number, String profileDescription, String address, Date birthDate, Country nationality, Country birthPlace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.profileDescription = profileDescription;
        this.address = address;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.birthPlace = birthPlace;
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return this.id.intValue();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return this.email;
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

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProfileDescription() {
        return this.profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getNationality() {
        return this.nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Country getBirthPlace() {
        return this.birthPlace;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }

    public List<UserSkill> getSkills() {
        return this.skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    public String toString() {
        return "User{id=" + this.id + ", name=" + this.name + ", surname=" + this.surname + ", email=" + this.email + ", number=" + this.number + ", profileDescription=" + this.profileDescription + ", address=" + this.address + ", birthDate=" + this.birthDate + ", nationality=" + this.nationality + ", birthPlace=" + this.birthPlace + ", skills=" + this.skills + '}';
    }
}
