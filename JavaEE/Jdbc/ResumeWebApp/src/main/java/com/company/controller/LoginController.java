package com.company.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
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

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private UserDaoInter userDaoInter = Context.instanceUserDao();
    private BCrypt.Verifyer bCrypt = BCrypt.verifyer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = userDaoInter.getByEmail(email);
            if (user == null) {
                throw new IllegalArgumentException("Not Found User!!!");
            }
            BCrypt.Result rs = bCrypt.verify(password.toCharArray(),user.getPassword().toCharArray());
            if(!rs.verified){
                throw new IllegalArgumentException("email or password is incorrect!!!");
            }
            request.getSession().setAttribute("loggedInUser", user);
            response.sendRedirect("/resume");
        }catch (Exception ex){
           ControllerUtil.errorPage(response,ex);
        }

    }
}
