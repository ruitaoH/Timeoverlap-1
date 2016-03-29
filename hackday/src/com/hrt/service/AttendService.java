package com.hrt.service;

import com.hrt.domain.*;
import com.hrt.util.*;

import java.sql.ResultSet;

public class AttendService {
    public boolean addAttend(Attend attend){
        boolean result = true;

        String sql = "insert into attend values(?,?,?,?)";
        String  [] parameters = {attend.getAc_id(),attend.getUs_id(),attend.getName(),attend.getChoices()};

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

    public int getCount(String ac_id){
        int count = 0;

        String sql = "select count(*) from attend where ac_id='" + ac_id + "'";
        ResultSet rs = SqlHelper.executeQuery(sql,null);

        try{
            if(rs.next()){
                count = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
        }

        return count;
    }

    public Attend[] getAttends(String ac_id,int count){
        Attend [] attends = new Attend[count];

        String sql = "select * from attend where ac_id='" + ac_id + "'";
        ResultSet rs = SqlHelper.executeQuery(sql,null);

        try{
            for(int i = 0;rs.next();i++){
                attends[i] = new Attend(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
        }

        return attends;
    }
}
