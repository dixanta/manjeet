/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.controller;

import com.cibt.jdbc.dao.UserDAO;
import com.cibt.jdbc.dao.impl.UserDAOImpl;
import com.cibt.web.entity.User;
import java.io.IOException;import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "home", urlPatterns = {"/", "/home"})
public class HomeController extends Controller {

    UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name", "Manjeet Shakya CMS Login");

        view("home/index", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        try{
            User user=userDAO.login(userName, password);
            if(user!=null){
                request.getSession(true)
                    .setAttribute("user", user);
                response.sendRedirect(request.getContextPath()
                +"/admin");
            }else{
                response.sendRedirect(request.getContextPath()
                +"/home?error");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
