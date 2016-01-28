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
        DBObject next;
        boolean success = false;
        DBCollection userCollection = MongoUtils.getDBCollection("user", "user");
        String userID = request.getParameter("userid");
        String userPassword = request.getParameter("password");
        System.out.println(userID);
        System.out.println(userPassword);
        DBCursor cursor = userCollection.find(new BasicDBObject()
                .append("userid",userID)
                .append("password",userPassword));

        if(cursor.hasNext()){
            response.getWriter().write(cursor.next().toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
