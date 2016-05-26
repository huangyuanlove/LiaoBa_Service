package com.huangyuanlove.dao;

import com.huangyuanlove.util.MD5Utils;
import com.huangyuanlove.util.MongoUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by huangyuan on 16-1-24.
 */
@WebServlet(name = "Register")
public class Register extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------以下为注册服务的输出------");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        DBCollection userCollection = MongoUtils.getDBCollection("user", "user");
        String userid = request.getParameter("userid");
        String userPassword = request.getParameter("password");
        String md5Password = MD5Utils.MD5(userPassword);
        DBObject userBean = new BasicDBObject()
                .append("userid", userid)
                .append("password",md5Password)
                .append("uuid", UUID.randomUUID() + "")
                .append("record", 0.0);


        DBCursor cursor = userCollection.find(new BasicDBObject().append("userid", userid));
        if(cursor.hasNext())
        {
            return ;
        }
        userCollection.insert(userBean);
        response.getWriter().write(userBean.toString());
        System.out.println(userBean.toString());
        System.out.println("------注册服务输出完毕------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
