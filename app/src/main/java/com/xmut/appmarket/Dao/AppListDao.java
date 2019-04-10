package com.xmut.appmarket.Dao;
/*
*       获取APP推荐列表（按照下载量排序）
*       返回List对象
* */


import com.xmut.appmarket.model.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppListDao {

    private Connection conn=null; //打开数据库对象
    private PreparedStatement ps=null;//操作整合sql语句的对象
    private ResultSet rs=null;//查询结果的集合
    public AppListDao()
    {
        conn= DBUtil.getConn();
    }
    public List<App> getAppList()
    {
        List<App> list=new ArrayList<App>();
        String sql="select * from AppTable";
        try {
            if(conn!=null&&(!conn.isClosed())){
                ps= (PreparedStatement) conn.prepareStatement(sql);
                if(ps!=null){
                    rs= ps.executeQuery();
                    if(rs!=null){
                        while(rs.next()){
                            App app=new App();
                            app.setAppID(rs.getInt("appID"));
                            app.setAppName(rs.getString("appName"));
                            app.setAppDownload(rs.getInt("appDownload"));
                            app.setAppLink(rs.getString("appLink"));
                            app.setAppPicture(rs.getString("appPicture"));
                            list.add(app);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeAll(conn,ps,rs);//关闭相关操作
        return list;
    }

}
