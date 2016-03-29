package com.hrt.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 这是一个操作数据库的工具类
 */
public class SqlHelper {
    private static Connection ct = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    //调用存储过程
    private static CallableStatement cs = null;

    private static String driver = "";
    private static String url = "";
    private static String username = "";
    private static String password = "";

    private static Properties pp = null;
    private static InputStream is = null;

    static{
        try {
            pp = new Properties();
//            fis = new FileInputStream("dbinfo.properties");//=>tomcat的主目录
            //java web项目要使用类加载器=>类加载器以src文件为主目录
            is = SqlHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
            //如果配置文件放置到了包下面应该这么来写
            //is = SqlHelper.class.getClassLoader().getResourceAsStream("com.hrt.service.dbinfo.properties");
            pp.load(is);
            driver = pp.getProperty("driver");
            url = pp.getProperty("url");
            username = pp.getProperty("username");
            password = pp.getProperty("password");
            //加载驱动：为什么加载驱动要在static代码块中
            //只会调用一次,不需要反复加载
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            is = null;
        }
    }

    //得到连接
    public static Connection getConnection(){
        try {
            ct = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ct;
    }

    //分页问题
//    public static ResultSet executeQuery2(){
//
//    }

    //调用存储过程，返回Result
    //sql call 过程（？，？，？）
    public static CallableStatement callPro2(String sql,String [] inparameters,Integer [] outparameters){
        try{
            ct = getConnection();
            cs = ct.prepareCall(sql);
            if(inparameters != null){
                for(int i = 0;i < inparameters.length;i++){
                    cs.setObject(i + 1,inparameters[i]);
                }
            }

            //给out参数
            if(outparameters != null){
                for(int i = 0;i < outparameters.length;i++){
                    cs.registerOutParameter(inparameters.length + i + 1,outparameters[i]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally {
            //不需要关闭
        }
        return cs;
    }

    //调用存储过程
    public static void callPro1(String sql,String [] parameters){
        try{
            ct = getConnection();
            cs = ct.prepareCall(sql);

            if(parameters != null){
                for(int i = 0;i < parameters.length;i++){
                    cs.setObject(i + 1,parameters[i]);
                }
            }
            cs.execute();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally {
            close(rs,cs,ct);
        }
    }

    //统一的select
    //ResultSet->ArrayList
    public static ResultSet executeQuery(String sql,String [] parameters){
        try{
            ct = getConnection();
            ps = ct.prepareStatement(sql);
            if(parameters != null && !parameters.equals("")){
                for(int i = 0;i < parameters.length;i++){
                    ps.setObject(i + 1,parameters[i]);
                }
            }
            rs = ps.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally {
            //close(rs,ps,ct);
        }
        return  rs;
    }

    //如果有多个update/delete/insert
    public static void executeUpdata2(String sql[],String [][] parameters){
        try{
            ct = getConnection();
            ct.setAutoCommit(false);

            for(int i = 0;i < sql.length;i++){
                if(parameters[i] != null){
                    ps = ct.prepareStatement(sql[i]);
                    for(int j = 0;j < parameters[i].length;j++){
                        ps.setObject(j + 1,parameters[i][j]);
                    }
                    ps.executeUpdate();
                }
            }
            ct.commit();
        }catch (Exception e){
            e.printStackTrace();

            //回滚
            try{
                ct.rollback();
            }catch (Exception arg0){
                arg0.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());
        }finally {
            close(rs,ps,ct);
        }
    }

    //一个update/delete/insert
    public static void executeUpadte(String sql,String [] parameters){
        try{
            ct = getConnection();
            ps = ct.prepareStatement(sql);
            if(parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    ps.setObject(i + 1, parameters[i]);
                }
            }
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally {
            close(rs,ps,ct);
        }
    }

    //关闭资源
    public static void close(ResultSet rs,PreparedStatement ps,Connection ct){
        if(rs != null){
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            rs = null;
        }
        if(ps != null){
            try{
                ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            ps = null;
        }
        if(ct != null){
            try{
                ct.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            ct = null;
        }
    }

    //get方法
    public static Connection getCt() {
        return ct;
    }

    public static PreparedStatement getPs() {
        return ps;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static CallableStatement getCs() {
        return cs;
    }
}
