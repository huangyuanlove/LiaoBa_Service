package com.huangyuanlove.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangyuan on 16-6-6.
 */
@WebServlet(name = "AdminLogIn")
public class AdminLogIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("name");
        String adminPassword = request.getParameter("password");
        if(adminName.equals("huangyuan") && adminPassword.equals("amw"))
        {
            response.sendRedirect("/LiaoBa/AdminIndex.jsp");
//            request.getRequestDispatcher("SpaceLab/index.jsp").forward(request,response);
        }
        else
        {
            request.setAttribute("name",adminName);
            request.setAttribute("password",adminPassword);
            request.setAttribute("err_message","帐号或密码错误");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
