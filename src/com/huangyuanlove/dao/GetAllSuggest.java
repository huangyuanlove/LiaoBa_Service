package com.huangyuanlove.dao;

import com.huangyuanlove.bean.ChatLogBean;
import com.huangyuanlove.bean.SuggestBean;
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
@WebServlet(name = "GetAllSuggest")
public class GetAllSuggest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------以下为查看反馈意见服务的输出------");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        ArrayList<SuggestBean> suggestBeans = new ArrayList<SuggestBean>();
        Mongo mongo = new Mongo();
        DB mongoDB = mongo.getDB("user");
        DBCollection suggest =mongoDB.getCollection("suggest");
        DBCursor cursor = suggest.find();
        while (cursor.hasNext())
        {
            DBObject next = cursor.next();
            SuggestBean suggestBean = new SuggestBean();
            suggestBean.setUserid((String)next.get("userid"));
            suggestBean.setTime((String)next.get("time"));
            suggestBean.setContent((String)next.get("content"));
            suggestBeans.add(suggestBean);
        }
        System.out.println(suggestBeans.size());
        request.setAttribute("suggests",suggestBeans);
        request.getRequestDispatcher("/Feedback.jsp").forward(request,response);
        System.out.println("------查看反馈意见服务的输出完毕------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
