package com.company.controller;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 23/05/2020
 * Time: 03:12
 */

import com.company.dto.*;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersRestController {

    @Autowired
    @Qualifier("userServiceImplData")
    private UserServiceInter userServiceInter;

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        List<User> userList = userServiceInter.getAll();
        List<UserDto> userDtoList = new ArrayList<>();
        userList.forEach(user -> {
            UserDto userDto = changeUserDto(user);
            userDtoList.add(userDto);
        });
        ResponseDto responseDto = ResponseDto.of(userDtoList, "Success find all users!");
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/users/search")
    public ResponseEntity getUserByParam(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname) {
        List<User> userList = userServiceInter.searchAllUser(name, surname);
        ResponseDto responseDto;
        if(userList.size()==0){
            responseDto = ResponseDto.of(404, "There is no user with this name or surname!");
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        }
        List<UserDto> userDtoList = new ArrayList<>();
        userList.forEach(user -> {
            UserDto userDto = changeUserDto(user);
            userDtoList.add(userDto);
        });
        String successMessage = "Success find name = " + name + ", surname = " + surname + " user!";
        responseDto = ResponseDto.of(userDtoList, successMessage);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Integer id) {
        User user;
        ResponseDto responseDto;
        try {
            user = userServiceInter.getById(id);
            UserDto userDto = changeUserDto(user);
            responseDto = ResponseDto.of(userDto, "Success find id = " + id + " user!");
        } catch (Exception ex) {
            responseDto = ResponseDto.of(404, "There is no user with this id!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Integer id) {
        User user;
        ResponseDto responseDto;
        try {
            user = userServiceInter.getById(id);
            UserDto userDto = changeUserDto(user);
            userServiceInter.removeUser(id);
            responseDto = ResponseDto.of(userDto, "Successfully deleted!" );
        } catch (Exception ex) {
            responseDto = ResponseDto.of(404, "There is no user with this id!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    private UserDto changeUserDto(User user) {
        UserDto userDto = new UserDto();
        List<UserSkillDto> userSkillDtoList = new ArrayList<>(user.getSkills().size());
        user.getSkills().forEach(userSkill -> {
            userSkillDtoList.add(changeUserSkillDto(userSkill));
        });
        userDto
                .setId(user.getId())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .setNumber(user.getNumber())
                .setAddress(user.getAddress())
                .setBirthDate(user.getBirthDate().toString())
                .setProfileDescription(user.getProfileDescription())
                .setSkills(userSkillDtoList)
                .setBirthplaceId(new CountryDto(user.getBirthPlace().getId(), user.getBirthPlace().getName(), user.getBirthPlace().getNationality()))
                .setNationalityId(new CountryDto(user.getNationality().getId(), user.getNationality().getName(), user.getNationality().getNationality()));
        return userDto;
    }

    private UserSkillDto changeUserSkillDto(UserSkill userSkill) {
        UserSkillDto userSkillDto = new UserSkillDto();
        userSkillDto
                .setId(userSkill.getId())
                .setPower(userSkill.getPower())
                .setSkill(new SkillDto(userSkill.getSkill().getId(), userSkill.getSkill().getName()));
        return userSkillDto;
    }
}