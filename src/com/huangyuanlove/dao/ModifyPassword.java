package com.huangyuanlove.dao;

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
        DBCollection userCollection = MongoUtils.getDBCollection("user", "user");
        String userID = request.getParameter("userID");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String uuid = request.getParameter("uuid");
        DBCursor cursor = userCollection.find(new BasicDBObject()
                .append("userID", userID)
                .append("password", oldPassword)
                .append("uuid", uuid));

        if (cursor.hasNext()) {
            userCollection.update(
                    new BasicDBObject()
                            .append("userID", userID)
                            .append("password", oldPassword)
                            .append("uuid", uuid),
                    new BasicDBObject()
                            .append("userID", userID)
                            .append("password", oldPassword)
                            .append("uuid", UUID.randomUUID()+"")
            );
        }

        cursor = userCollection.find();
        if(cursor.hasNext())
        {
            DBObject next = cursor.next();
            System.out.println(next.get("userID"));
            System.out.println(next.get("password"));
            System.out.println(next.get("uuid"));
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
