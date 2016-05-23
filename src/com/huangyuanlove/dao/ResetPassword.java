package com.huangyuanlove.dao;

import com.huangyuanlove.util.MongoUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangyuan on 16-5-19.
 */
@WebServlet(name = "ResetPassword")
public class ResetPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("------以下为重置密码服务的输出------");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uuid = request.getParameter("uuid");
        DBCollection userCollection = MongoUtils.getDBCollection("user", "user");
        DBObject dbObject = userCollection.findOne(new BasicDBObject().append("uuid", uuid));

        dbObject.put("password","670B14728AD9902AECBA32E22FA4F6BD");
        userCollection.findAndModify(new BasicDBObject().append("uuid", uuid), dbObject);
        response.sendRedirect("/LiaoBa/listall.do");
        System.out.println("------重置密码服务的输出完毕------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
