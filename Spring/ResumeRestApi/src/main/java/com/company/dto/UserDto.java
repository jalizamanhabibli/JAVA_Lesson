package com.company.dto;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 15/05/2020
 * Time: 05:29
 */
public class UserDto {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String number;
    private String birthDate;
    private String profileDescription;
    private List<UserSkillDto> skills;
    private CountryDto birthplaceId;
    private CountryDto nationalityId;

    public UserDto() {
    }

    public UserDto(Integer id) {
        this.id = id;
    }

    public UserDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public UserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public UserDto setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public UserDto setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public UserDto setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public CountryDto getBirthplaceId() {
        return birthplaceId;
    }

    public UserDto setBirthplaceId(CountryDto birthplaceId) {
        this.birthplaceId = birthplaceId;
        return this;
    }

    public CountryDto getNationalityId() {
        return nationalityId;
    }

    public UserDto setNationalityId(CountryDto nationalityId) {
        this.nationalityId = nationalityId;
        return this;
    }

    public List<UserSkillDto> getSkills() {
        return skills;
    }

    public UserDto setSkills(List<UserSkillDto> skills) {
        this.skills = skills;
        return this;
    }
}
