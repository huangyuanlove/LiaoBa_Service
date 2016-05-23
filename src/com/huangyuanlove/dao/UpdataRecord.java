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
@WebServlet(name = "UpdataRecord")
public class UpdataRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------以下为上传记录服务的输出------");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uuid = request.getParameter("uuid");
        double record = Double.valueOf(request.getParameter("record"));
        DBCollection userCollection = MongoUtils.getDBCollection("user", "user");
        DBObject dbObject = userCollection.findOne(new BasicDBObject().append("uuid", uuid));
        dbObject.put("record",record);
        userCollection.findAndModify(new BasicDBObject().append("uuid", uuid), dbObject);
        response.getWriter().write("ok");
//        request.getRequestDispatcher("/listall.do").forward(request,response);
        System.out.println("------上传记录服务的输出完毕------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
