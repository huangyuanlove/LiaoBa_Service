package com.huangyuanlove.dao;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huangyuanlove.util.MongoUtils;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangyuan on 16-1-24.
 */
@WebServlet(name = "Login")
public class Login extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("------以下为登录服务的输出------");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        DBCollection userCollection = MongoUtils.getDBCollection("user", "user");
        String userid = request.getParameter("userid");
        String userPassword = request.getParameter("password");
        System.out.println(userid);
        System.out.println(userPassword);
        DBCursor cursor = userCollection.find(new BasicDBObject()
                .append("userid",userid)
                .append("password",userPassword));

        if(cursor.hasNext()){
            response.getWriter().write(cursor.next().toString());
        }

        System.out.println("------登录服务输出完毕------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
