package com.huangyuanlove.dao;

import com.mongodb.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangyuan on 16-3-12.
 */
@WebServlet(name = "Updata")
public class Updata extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------以下为软件更新的输出------");
//        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String version = request.getParameter("version");
        System.out.println("参数"+version);
        String responseString = "";
        Mongo mongo = new Mongo();
        DB mongoDB = mongo.getDB("user");
        DBCollection updataCollection =mongoDB.getCollection("updata");
        BasicDBObject orderBy = new BasicDBObject("_id",-1);
        DBCursor updataCursor = updataCollection.find().sort(orderBy).limit(1);
        if(updataCursor.hasNext())
        {
            DBObject updataObj = updataCursor.next();
            System.out.println(updataObj.toString());
            if(!version.equals(updataObj.get("version").toString()))
            {
                responseString = updataObj.toString();
            }
            else
            {
                responseString = "";
            }
        }
        System.out.println("g返回客户端的数据："+responseString);
        response.getWriter().write(responseString);
        System.out.println("------软件更新的输出完毕------");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
