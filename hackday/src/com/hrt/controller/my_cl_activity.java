package com.hrt.controller;

import com.hrt.domain.Activity;
import com.hrt.domain.Attend;
import com.hrt.domain.User;
import com.hrt.service.ActivityService;
import com.hrt.service.AttendService;
import com.hrt.service.UserService;
import com.sun.javafx.collections.MappingChange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "my_cl_activity")
public class my_cl_activity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String ac_code = request.getParameter("a") + request.getParameter("b") + request.getParameter("c") + request.getParameter("d");
        ActivityService as = new ActivityService();

//        System.out.println(ac_code);
        if(as.checkActivity(ac_code)){
            //调取活动信息
            Activity activity = as.getActivity_code(ac_code);

            //调取发起人信息
            UserService us = new UserService();
            User user = us.getUser_id(activity.getUs_id());

            AttendService ats = new AttendService();
            int count = ats.getCount(activity.getAc_id());

            request.setAttribute("主题",activity.getSubject());
            request.setAttribute("发起人",user.getName());
            request.setAttribute("联系电话",user.getPhone());
            request.setAttribute("地点",activity.getPlace());
            request.setAttribute("已填人数",count);

            String date = activity.getDate();
            String [] dates = date.split(";");
            String [] days = {"上午","中午","下午","晚上"};

            //判断各个时间有多少个人可能参加
            //取出来所有的Attend
            Attend [] attends = ats.getAttends(activity.getAc_id(),count);

            String [] choices = new String[count];
            Set<String> s_dates = new HashSet<String >();

            for(int i = 0;i < count;i++){
                choices[i] = attends[i].getChoices();
            }

            String [] times = new String[20];
            for(int i = 0;i < times.length;i++){
                int j = i / 4;
                int z = i % 4;
                times[i] = dates[j] + " " + days[z];
            }

            Map<String,Integer> map_choice = new HashMap<String,Integer>();
            Map<String,Integer> map_real_choice = new HashMap<String,Integer>();
            for(int i = 0;i < times.length;i++){
                map_choice.put(times[i],0);
                map_real_choice.put(times[i],0);
            }

            //计算总结果
            for(int i = 0;i < count;i++){
                String [] a = choices[i].split(",");
                for(int j = 0;j < a.length;j++){
                    map_choice.put(times[j],map_choice.get(times[j]) + Integer.parseInt(a[j]));
                }
            }

            for(int i = 0;i < count;i++){
                String [] a = choices[i].split(",");
                for(int j = 0;j < a.length;j++){
                    int z = Integer.parseInt(a[j]);
                    if(z != 2) {
                        map_real_choice.put(times[j], map_real_choice.get(times[j]) + Integer.parseInt(a[j]));
                    }else{
                        map_real_choice.put(times[j], map_real_choice.get(times[j]) + 1);
                    }
                }
            }

            //给map排序
            List<Map.Entry<String,Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map_choice.entrySet());

//            for (int i = 0; i < infoIds.size(); i++) {
//                String id = infoIds.get(i).toString();
//                System.out.println(id);
//            }

            Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue() - o1.getValue()); //后面 - 前面 降序
//                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });

            System.out.println("--------------------排序后");
            for (int i = 0; i < infoIds.size(); i++) {
                Map.Entry<String,Integer> id = infoIds.get(i);
                System.out.println(id.getKey() + "=" + id.getValue());
            }

            List<Map.Entry<String,Integer>> list_choice = new ArrayList<Map.Entry<String, Integer>>(map_real_choice.entrySet());
            List<Map.Entry<String,Integer>> real_choice = new ArrayList<Map.Entry<String, Integer>>();  // ----- 有用
            for(int i = 0;i < infoIds.size();i++){
                for(int j = 0;j < map_real_choice.size();j++){
                    if(infoIds.get(i).getKey().equals(list_choice.get(j).getKey())){
                        real_choice.add(list_choice.get(j));
                    }
                }
            }

            System.out.println("--------------------排序后");
            for (int i = 0; i < real_choice.size(); i++) {
                String id = real_choice.get(i).toString();
                System.out.println(id);
            }

            Map<String,Map<String,String>> map_people = new HashMap<String,Map<String,String>>();
            for(int i = 0;i < real_choice.size();i++){
                Map<String,String> attend_people = new HashMap<String,String>();
                for(int j = 0;j < count;j++){
                    String [] a = choices[j].split(",");
                    for(int k = 0;k < a.length;k++){
                        if(real_choice.get(i).getKey().equals(times[k])){
                            int n = Integer.parseInt(a[k]);
                            if(n == 2){
                                attend_people.put(attends[j].getName(),"有时间");
                            }else if(n == 1){
                                attend_people.put(attends[j].getName(),"可能有时间");
                            }else{
                                attend_people.put(attends[j].getName(),"没时间");
                            }
                        }
                    }
                }
                if(attend_people.size() != 0) {
                    map_people.put(real_choice.get(i).getKey(), attend_people);
                }
            }

            List<Map.Entry<String,Map<String,String>>> temp_people = new ArrayList<Map.Entry<String,Map<String,String>>>(map_people.entrySet());

            List<Map.Entry<String,Map<String,String>>> real_people = new ArrayList<Map.Entry<String,Map<String,String>>>();  // -----有用
            for(int i = 0;i < real_choice.size();i++){
                for(int j = 0;j < temp_people.size();j++) {
                    if (real_choice.get(i).getKey().equals(temp_people.get(j).getKey())){
                        real_people.add(temp_people.get(j));
                    }
                }
            }

            System.out.println("--------------------排序后");
            for (int i = 0; i < real_people.size(); i++) {
                String id = real_people.get(i).toString();
                System.out.println(id);
            }


//            //过滤重复项
//            for(int i = 0;i < count;i++){
//                String [] a = choices[i].split(",");
//                for(int j = 0;j < a.length;j++){
//                    int b = Integer.parseInt(a[j]);
//                    if(b  != 0){
//                        s_dates.add(getDate(j,dates));
//                    }
//                }
//            }
//
//            HashMap<String,Integer> choice_map = new HashMap<String,Integer>();
//
//            for(String d : s_dates){
//                choice_map.put(d,0);
//            }
//
//            for(Attend attend : attends){
//                int key = choice_map.get(attend.getChoices());
//
//                String [] a = attend.getChoices().split(",");
//                for(int i = 0;i < a.length;i++) {
//                    int b = Integer.parseInt(a[i]);
//                    if(b != 0) {
//                        choice_map.put(getDate(i, dates), key++);
//                    }
//                }
//            }
//
//            String [] keys = new String[choice_map.size()];
//            int [] vals = new int[choice_map.size()];
//
//            Iterator iter = choice_map.entrySet().iterator();
//            int i = 0;
//            while (iter.hasNext()) {
//                HashMap.Entry<String,Integer> entry = (HashMap.Entry<String,Integer>) iter.next();
//                String key = entry.getKey();
//                Integer val = entry.getValue();
//                keys[i] = key;
//                vals[i] = val;
//                i++;
//            }
//
//            //创建int类型的二位数组
//            int [][] key = new int[attends.length][20];
//            for(int i = 0;i < attends.length;i++){
//                String [] a = choices[i].split(",");
//                for(int j = 0;j < a.length;j++){
//                    int b = Integer.parseInt(a[j]);
//                    key[i][j] = b;
//                }
//            }
//
//            int [] result = new int[20];
//
//            for(int i = 0;i < 20;i++){
//                result[i] = 0;
//            }
//
//            for(int i = 0;i < 20;i++){
//                for(int j = 0;j < attends.length;j++){
//                    result[i] += key[j][i] * 0.5;
//                }
//            }
//            request.setAttribute("数据",result);

            request.setAttribute("real_choice",real_choice);
            request.setAttribute("real_people",real_people);
            request.setAttribute("user",user);
            request.setAttribute("activity",activity);

            request.getRequestDispatcher("/hackday/My_activity.jsp").forward(request,response); //跳转到发起人看的页面------------------------>跳转的页面路径还需再去写
        }else {
            request.setAttribute("err","您输入的用户秘钥错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response); //----------------->这里返回过去不能用html ---->否则无法显示err的信息
        }
    }
}
