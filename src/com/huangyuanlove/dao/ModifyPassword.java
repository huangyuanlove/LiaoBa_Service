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
 * Created by huangyuan on 16-1-28.
 */
@WebServlet(name = "ModifyPassword")
public class ModifyPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------以下为修改密码服务的输出------");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        DBCollection userCollection = MongoUtils.getDBCollection("user", "user");
        String userid = request.getParameter("userid");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String uuid = request.getParameter("uuid");
        double record = Double.valueOf(request.getParameter("record"));

        DBCursor cursor = userCollection.find(new BasicDBObject()
                .append("userid", userid)
                .append("password", MD5Utils.MD5(oldPassword))
                .append("uuid", uuid));

        if (cursor.hasNext()) {
            userCollection.update(
                    cursor.next(),
                    new BasicDBObject()
                            .append("userid", userid)
                            .append("password", MD5Utils.MD5(newPassword))
                            .append("uuid", UUID.randomUUID() + "")
                            .append("record", record)
            );
            System.out.println("密码修改成功");

            cursor = userCollection.find(
                    new BasicDBObject()
                            .append("userid", userid)
                            .append("password", MD5Utils.MD5(newPassword)));
            System.out.println("共有" + cursor.count() + "个");

            if (cursor.hasNext()) {
                DBObject next = cursor.next();
                System.out.println(next.toString());
                response.getWriter().write(next.toString());
            }
        }

        System.out.println("------修改密码服务输出完毕------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
