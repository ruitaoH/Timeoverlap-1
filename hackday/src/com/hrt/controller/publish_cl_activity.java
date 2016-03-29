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

@WebServlet(name = "publish_cl_activity")
public class publish_cl_activity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String ac_code = request.getParameter("ac_code");

        if("".equals(ac_code) || ac_code == null){
            //没有带着ac_code->非法盗链
            request.setAttribute("err","您非法盗链了");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            ActivityService as = new ActivityService();
            //如果不是空,去数据库验证
            if(as.checkActivity(ac_code)){
                //调取信息传递到下一个页面->主题、发起人、联系电话、地点、截止时间
                Activity activity = as.getActivity_code(ac_code);

                UserService us = new UserService();
                User user = us.getUser_id(activity.getUs_id());

                HttpSession session = request.getSession();
                session.setAttribute("发起者",user);
                session.setAttribute("活动",activity);
                session.setMaxInactiveInterval(3600 * 24);
                //----------------------------->设置session的时间？？？

                request.setAttribute("主题",activity.getSubject());
                request.setAttribute("发起人",user.getName());
                request.setAttribute("联系电话",user.getPhone());
                request.setAttribute("地点",activity.getPlace());
                request.setAttribute("提交截止时间",activity.getDead());
                request.setAttribute("时间",activity.getDate());

                request.getRequestDispatcher("hackday/Attend_activity.jsp").forward(request,response); //跳转到参与者填写的页面----------------->跳转的页面路径还需再去写
            }else {
                //带有的ac_code不正确->非法盗链
                request.setAttribute("err","您访问的ac_code不存在");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
        }
    }
}
