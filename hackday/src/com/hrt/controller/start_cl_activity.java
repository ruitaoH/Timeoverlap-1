package com.hrt.controller;

import com.hrt.domain.Activity;
import com.hrt.domain.User;
import com.hrt.service.ActivityService;
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

@WebServlet(name = "start_cl_activity")
public class start_cl_activity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String subject = request.getParameter("subject"); //主题
        String date = request.getParameter("month_1") + ";" + request.getParameter("month_2") + ";" +request.getParameter("month_3") + ";" +request.getParameter("month_4") + ";" +request.getParameter("month_5"); //日历选择的多天

        Float last = Float.parseFloat(request.getParameter("time")); //活动时长
        String dead = request.getParameter("date_day") + "/" +  request.getParameter("data_minute"); //截止时间
        String name = request.getParameter("people"); //用户名
        String ac_code = makeNum(); //活动秘钥------------------>这个还要在核对
        String place = request.getParameter("else_1"); //活动地点（选填）
        String phone = request.getParameter("else_2"); //联系电话（选填）

        //先把发起者添加到数据库
        User user = null;
        String us_id = makeId();
        if("".equals(phone) || phone == null){
            user = new User(us_id,name,null);
        }else {
            user = new User(us_id, name, phone);
        }
        UserService us = new UserService();
        us.addUser(user);

        //把活动添加到数据库
        Activity activity = null;
        String ac_id = makeId();
        if("".equals(place) || place == null){
            activity = new Activity(ac_id,subject,date,last,dead,us_id,null,ac_code);
        }else {
            activity = new Activity(ac_id,subject,date,last,dead,us_id,place,ac_code);
        }
        ActivityService as = new ActivityService();
        as.addActivity(activity);

        //回送回页面一个链接
        out.println("<p style='font-size:100px;color:blue;text-align:center'>问卷链接是：http://localhost:8080/test/publish_cl_activity?ac_code=" + ac_code + "</span><br />");
        out.println("<p style='font-size:100px;color:blue;text-align:center'>你的用户秘钥是：" + ac_code + "</span><br />");
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
