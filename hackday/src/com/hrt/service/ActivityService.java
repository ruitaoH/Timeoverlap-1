package com.hrt.service;

import com.hrt.domain.*;
import com.hrt.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ActivityService {
//
//    //验证用户是否合法
//    public boolean checkUsers(Users users){
//        boolean result = false;
//
//        //使用SqlHelper来完成查询任务
//        String sql = "select * from users where id=? and password=?";
//        String parameters[] = {users.getId() + "",users.getPassword()};
//        ResultSet rs = SqlHelper.executeQuery(sql,parameters);
//
//        //根据rs来判断用户是否存在
//        try {
//            if (rs.next()) {
//                result = true;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
//        }
//        return result;
//    }
//
//    //按照分页来获取数据
//    //返回值 ResultSet->Users->ArrayList、Vector等（集合）
//    public ArrayList getUsersByPage(int pageNow,int pageSize){
//        ArrayList<Users> al = new ArrayList<Users>();
//
//        String sql = "select * from users order by id limit " + (pageNow - 1) * pageSize + "," + pageSize;
//
//        ResultSet rs = SqlHelper.executeQuery(sql,null);
//
//        //封装到ArrayList
//        try {
//            while (rs.next()) {
//                Users users = new Users();
//                users.setId(rs.getInt(1));
//                users.setUsername(rs.getString(2));
//                users.setEmail(rs.getString(3));
//                users.setGrade(rs.getInt(4));
//                users.setPassword(rs.getString(5));
//
//                //不要忘记把users放入ArrayList中
//                al.add(users);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
//        }
//        return al;
//    }
//
//    //得到pageCount
//    public int getPageCount(int pageSize){
//        int pageCount = 0;
//        String sql = "select count(*) from users";
//
//        ResultSet rs = SqlHelper.executeQuery(sql,null);
//        try {
//            rs.next();
//            int rowCount = rs.getInt(1);
//
//            if(rowCount % pageSize == 0){
//                pageCount = rowCount / pageSize;
//            }else{
//                pageCount = rowCount / pageSize + 1 ;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
//        }
//        return pageCount;
//    }
//
//    //删除用户
//    public  boolean delUsers(int id){
//        boolean result = true;
//
//        String sql = "delete from users where id=" + id;
////        String parameters[] = {id};
//        try {
//            SqlHelper.executeUpadte(sql, null);
//        }catch (Exception e){
//            result = false;
//        }
//        return result;
//    }
//
//    //添加用户
//    public boolean addUsers(MyUser myUser){
//        boolean result = true;
//
//        int id = myUser.getId();
//        String date = myUser.getDate();
//
//        System.out.println(date);
//
//        String sql = "insert into date values(" + id + ",'" + date + "')";
//
//        try{
//            SqlHelper.executeUpadte(sql,null);
//        }catch (Exception e){
//            result = false;
//        }finally {
//            SqlHelper.close(SqlHelper.getRs(),SqlHelper.getPs(),SqlHelper.getCt());
//        }
//
//        return result;
//    }

    public boolean addActivity(Activity activity){
        boolean result = true;

        String sql = "insert into activity values(?,?,?,?,?,?,?,?)";
        Float last = activity.getLast();
        String s_last = last.toString();
        String [] parameters = {activity.getAc_id(),activity.getSubject(),activity.getDate(),s_last,activity.getDead(),activity.getUs_id(),activity.getPlace(),activity.getAc_code()};

        try{
            SqlHelper.executeUpadte(sql,parameters);
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }finally {
            SqlHelper.close(SqlHelper.getRs(),SqlHelper.getPs(),SqlHelper.getCt());
        }

        return result;
    }

    public boolean checkActivity(String ac_code){
        boolean result = false;

        String sql = "select * from activity where ac_code=" + ac_code;
        ResultSet rs = SqlHelper.executeQuery(sql,null);

        try{
            if(rs.next()){
                result = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
        }

        return result;
    }

    public Activity getActivity_code(String ac_code){
        Activity activity = null;

        String sql = "select * from activity where ac_code=" + ac_code;
        ResultSet rs = SqlHelper.executeQuery(sql,null);

        try {
            if(rs.next()){
                activity = new Activity(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
        }

        return activity;
    }
}
