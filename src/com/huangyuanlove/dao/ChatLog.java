package com.huangyuanlove.dao;

import com.huangyuanlove.util.MongoUtils;
import com.mongodb.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangyuan on 16-2-13.
 */
@WebServlet(name = "ChatLog")
public class ChatLog extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("------以下为聊天记录服务的输出------");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userid = request.getParameter("uuid");
        String content = request.getParameter("content");
        Mongo mongo = new Mongo();
        DB mongoDB = mongo.getDB("user");

        DBCollection chatCollection =mongoDB.getCollection("chat");
        DBObject chatLog = new BasicDBObject().append("UUID",userid).append("content",content);
        chatCollection.insert(chatLog);

        System.out.println(chatLog.toString());
        System.out.println("------聊天记录服务的输出完毕------");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
