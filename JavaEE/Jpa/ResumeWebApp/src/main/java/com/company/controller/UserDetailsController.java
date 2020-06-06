package com.company.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;
import com.company.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserDetailsController", urlPatterns = "/userDetails" )
public class UserDetailsController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idStr = request.getParameter("id");
            if (idStr == null || idStr.trim().isEmpty()) {
                throw new IllegalArgumentException("id is not specified");
            }
            Integer id = Integer.valueOf(idStr);
            UserDaoInter userDaoInter = Context.instanceUserDao();
            User user = userDaoInter.getById(id);
            if (user == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            request.setAttribute("user", user);
            request.getRequestDispatcher("userDetails.jsp").forward(request, response);
        }catch (Exception ex){
            ControllerUtil.errorPage(response,ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ControllerUtil.errorPage(resp,new Exception("id is not specified"));
    }
}