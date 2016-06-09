package com.huangyuanlove.dao;

import com.mongodb.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangyuan on 16-3-8.
 */
@WebServlet(name = "Suggest")
public class Suggest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("-------以下为意见反馈服务的输出-------");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uuid = request.getParameter("uuid");
        String userid = request.getParameter("userid");
        String time = request.getParameter("time");
        String content = request.getParameter("content");
        Mongo mongo = new Mongo();
        DB mongoDB = mongo.getDB("user");
        DBCollection suggestCollection =mongoDB.getCollection("suggest");
        DBObject suggest = new BasicDBObject().append("uuid",uuid)
                .append("userid",userid)
                .append("time",time)
                .append("content",content);
        suggestCollection.insert(suggest);
        System.out.println("-------意见反馈服务的输出------");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
