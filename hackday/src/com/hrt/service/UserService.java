package com.hrt.service;

import com.hrt.domain.*;
import com.hrt.util.*;
import jdk.nashorn.internal.runtime.ECMAException;

import java.sql.ResultSet;

public class UserService {
    public boolean addUser(User user){
        boolean result = true;

        String sql = "insert into user values(?,?,?)";
        String [] parameters = {user.getUs_id(),user.getName(), user.getPhone()};

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

    public User getUser_id(String us_id){
        User user = null;

        String sql = "select * from user where us_id='" + us_id + "'";
        ResultSet rs = SqlHelper.executeQuery(sql,null);

        try{
            if(rs.next()){
                user = new User(rs.getString(1),rs.getString(2),rs.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
        }

        return user;
    }
}
