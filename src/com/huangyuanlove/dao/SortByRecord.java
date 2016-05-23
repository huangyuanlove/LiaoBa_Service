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
 * Created by huangyuan on 16-5-23.
 */
@WebServlet(name = "SortByRecord")
public class SortByRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------以下为排序用户服务的输出------");
        List<UserBean> users = new ArrayList<UserBean>();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String from = request.getParameter("from");

        DBCollection userCollection = MongoUtils.getDBCollection("user", "user");
        DBCursor cursors = userCollection.find().sort(new BasicDBObject("record",-1));
        if("web".equals(from)) {
        while(cursors.hasNext())
        {
            DBObject cursor =  cursors.next();
            UserBean user = new UserBean();
            user.setUserid((String) cursor.get("userid"));
            user.setUUID((String)cursor.get("uuid"));
            user.setRecord((Double) cursor.get("record"));
            user.setPassword((String)cursor.get("password"));
            users.add(user);
        }
            request.setAttribute("userlist", users);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else
        {
            response.getWriter().write(cursors.toArray().toString());
        }
        System.out.println("------排序所有用户服务的输出完毕------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
