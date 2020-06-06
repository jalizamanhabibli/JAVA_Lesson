package com.company.controller;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "UsersController", urlPatterns = "/users")
public class UsersController extends HttpServlet {
    UserDaoInter userDaoInter = Context.instanceUserDao();
    CountryDaoInter countryDaoInter = Context.instanceCountryDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = null;
        if ("Search".equals(request.getParameter("search"))) {
            users = userDaoInter.searchAllUser(request.getParameter("name"), request.getParameter("surname"));
        } else if ("delete".equals(request.getParameter("action"))) {
            userDaoInter.removeUser(Integer.valueOf(request.getParameter("id")));
            users = userDaoInter.getAll();
        } else if ("edit".equals(request.getParameter("action"))) {
            editUser(request, response);
            users = userDaoInter.getAll();
        }
        request.setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userDaoInter.searchAllUser(request.getParameter("name"), request.getParameter("surname"));
        request.setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        User user = userDaoInter.getById(Integer.valueOf(request.getParameter("id")));
        Country birthplace = countryDaoInter.getCountryById(Integer.valueOf(request.getParameter("birthplace")).intValue());
        Country nationality = countryDaoInter.getCountryById(Integer.valueOf(request.getParameter("nationality")).intValue());
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setEmail(request.getParameter("email"));
        user.setNumber(request.getParameter("number"));
        user.setProfileDescription(request.getParameter("profiledescription"));
        user.setAddress(request.getParameter("address"));
        user.setBirthDate(Date.valueOf(request.getParameter("birthday")));
        user.setBirthPlace(birthplace);
        user.setNationality(nationality);
        userDaoInter.updateUser(user);
    }
}