package com.hrt.controller;

import com.hrt.domain.Activity;
import com.hrt.domain.Attend;
import com.hrt.domain.User;
import com.hrt.service.AttendService;
import com.hrt.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "attend_cl_activity")
public class attend_cl_activity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //调取数据
        String choice = request.getParameter("choice");

        String name = request.getParameter("name");
//        System.out.println(name);
//        //----------------------------->这个页面提不提供用户的电话？？？


        //把新用户存入数据库
//        String us_id = makeId();
//        User user = new User(us_id,name,null);
//        UserService us = new UserService();
//        us.addUser(user);

        //把参加选择存入数据库
        HttpSession session = request.getSession();
        Activity activity = (Activity) session.getAttribute("活动");
        Attend attend = new Attend(activity.getAc_id(),activity.getUs_id(),name,choice);
        AttendService ats = new AttendService();
        ats.addAttend(attend);

        //---------------------------------->修改的问题：需要先判断这个 用户名 和 us_code 是否数据库中没有？？？
    }

    public String makeNum(){
        Random r = new Random();
        String num = r.nextInt(9999) + "";
        //如果随机出来的数字不够4位,随机补零
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < 4 - num.length();i++){
            sb.append("0");
        }
        num = sb.toString() + num;
        return num;
    }

    public String makeId(){
        return java.util.UUID.randomUUID().toString().replaceAll("-","");
    }
}
