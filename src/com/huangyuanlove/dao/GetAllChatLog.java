package com.huangyuanlove.dao;

import com.huangyuanlove.bean.ChatLogBean;
import com.mongodb.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by huangyuan on 16-6-9.
 */
@WebServlet(name = "GetAllChatLog")
public class GetAllChatLog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------以下为查找聊天记录服务的输出------");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        ArrayList<ChatLogBean> chatLogBeans = new ArrayList<ChatLogBean>();
        String userid = request.getParameter("userid");
        Mongo mongo = new Mongo();
        DB mongoDB = mongo.getDB("user");

        DBCollection chatCollection =mongoDB.getCollection("chat");
        DBCursor dbCursor = null;
        if(userid == null || "".equals(userid))
        {
            dbCursor =  chatCollection.find();
        }
        else
        {
            dbCursor = chatCollection.find(new BasicDBObject().append("userid",userid));
        }

        while (dbCursor.hasNext())
        {
            DBObject next = dbCursor.next();
            ChatLogBean chatLogBean = new ChatLogBean();
            chatLogBean.setUUID((String) next.get("uuid"));
            chatLogBean.setUserid((String) next.get("userid"));
            chatLogBean.setContent((String) next.get("content"));
            chatLogBeans.add(chatLogBean);
        }
        request.setAttribute("chatLogs",chatLogBeans);
        request.getRequestDispatcher("/tables-chat-data.jsp").forward(request,response);
        System.out.println("------查找聊天记录服务的输出完毕------");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
