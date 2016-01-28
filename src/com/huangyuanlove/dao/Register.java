package com.huangyuanlove.dao;

import com.mongodb.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangyuan on 16-1-24.
 */
@WebServlet(name = "Register")
public class Register extends HttpServlet {
    private WriteResult insert;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mongo mongo = new Mongo();
        DB userDB = mongo.getDB("user");
        DBCollection userCollection = userDB.getCollection("user");

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        DBObject userBean = new BasicDBObject().append("username",userName)
                .append("password",userPassword);
        insert = userCollection.insert(userBean);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
