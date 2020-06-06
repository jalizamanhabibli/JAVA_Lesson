package com.company.controller;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 19/05/2020
 * Time: 05:33
 */

import com.company.dto.UserDto;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.service.inter.CountryServiceInter;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
public class UserDetailsController {

    @Autowired
    @Qualifier("userServiceImplData")
    UserServiceInter userServiceInter;

    @Autowired
    @Qualifier("countryServiceImplData")
    CountryServiceInter countryServiceInter;

    @PostMapping("/userDetails")
    public ModelAndView postUserDetails(@RequestParam("id") Integer id,RedirectAttributes redirectAttributes) {
        User user=userServiceInter.getById(id);
        ModelAndView modelAndView;
        if(user==null){
            modelAndView = new ModelAndView("redirect:/error");
            redirectAttributes.addFlashAttribute("msg",new IllegalArgumentException("There is no user with this id"));
            return modelAndView;
        }
        List<Country> countries = countryServiceInter.getAllCountries();
        UserDto userDto = changeUserDto(user);
        modelAndView = new ModelAndView("userDetails");
        modelAndView.addObject("updateUserDto", userDto);
        modelAndView.addObject("countries", countries);
        return modelAndView;
    }

    @GetMapping("/userDetails")
    public String getUserDetails(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg",new IllegalArgumentException("Id is not specified"));
        return "redirect:/error";
    }

    private UserDto changeUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto
                .setId(user.getId())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .setAddress(user.getAddress())
                .setNumber(user.getNumber())
                .setBirthDate(user.getBirthDate().toString())
                .setProfileDescription(user.getProfileDescription())
                .setBirthplaceId(user.getBirthPlace())
                .setNationalityId(user.getNationality());
        return userDto;

    }
}