package com.huangyuanlove.dao;

import com.huangyuanlove.bean.UserBean;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangyuan on 16-5-19.
 */
@WebServlet(name = "DeleteUser")
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("------以下为删除用户服务的输出------");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uuid = request.getParameter("uuid");
        DBCollection userCollection = MongoUtils.getDBCollection("user", "user");
        userCollection.findAndRemove(new BasicDBObject().append("uuid", uuid));
        response.sendRedirect("/LiaoBa/listall.do");
//        request.getRequestDispatcher("/listall.do").forward(request,response);


        System.out.println("------删除用户服务的输出完毕------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
