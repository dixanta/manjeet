/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.filter;

import com.cibt.web.entity.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig config){
        
    }
    
    public void doFilter(ServletRequest request, 
            ServletResponse response, 
                FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse)response;
        
        HttpSession session=req.getSession(false);
        if(session!=null && session.getAttribute("user")!=null){
            User user=(User)session.getAttribute("user");
            if(user!=null){
                chain.doFilter(req, resp);
            }
        }else{
            resp.sendRedirect(req.getContextPath() +
                    "/home");
        }
        
    }
    
    @Override
    public void destroy(){
        
    }
}
