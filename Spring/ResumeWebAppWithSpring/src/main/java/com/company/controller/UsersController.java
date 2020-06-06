package com.company.controller;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 15/05/2020
 * Time: 04:58
 */

import com.company.config.Config;
import com.company.dto.UserDto;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    @Qualifier("userServiceImplData")
    UserServiceInter userServiceInter;

    @ModelAttribute("userDto")
    public UserDto getUserDto() {
        return new UserDto();
    }

    @ModelAttribute("loggedInUser")
    public User loggedInUser() {
        return Config.getUser();
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> users = userServiceInter.getAll();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping(path = "/")
    public String postUsers(@ModelAttribute("updateUserDto") UserDto userDto, Model model) {
        User user = changeUser(userDto);
        userServiceInter.updateUser(user);
        List<User> users = userServiceInter.getAll();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping(path = "/deleteUser")
    public String deleteUser(@RequestParam(value = "id") Integer id) {
        userServiceInter.removeUser(id);
        return "redirect:/";
    }

    //        @RequestMapping(method = RequestMethod.POST)
//    public String postUsers(@RequestParam(value="name",required = false) String name,
//                            @RequestParam(value = "surname",required = false) String surname,
//                            Model model) {
//        List<User> users = userServiceInter.searchAllUser(name, surname);
//        model.addAttribute("users", users);
//        return "users";
//    }
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String getUserSearch(@ModelAttribute("userDto") UserDto userDto, Model model) {
        List<User> users = userServiceInter.searchAllUser(userDto.getName(), userDto.getSurname());
        model.addAttribute("users", users);
        return "/users";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    private User changeUser(UserDto userDto) {
        User user = userServiceInter.getById(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setNumber(userDto.getNumber());
        user.setAddress(userDto.getAddress());
        user.setProfileDescription(userDto.getProfileDescription());
        try {
            user.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(userDto.getBirthDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setNationality(userDto.getNationalityId());
        user.setBirthPlace(userDto.getBirthplaceId());
        return user;
    }
}
