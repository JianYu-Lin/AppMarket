package com.xmut.appmarket.Dao;

import android.util.Log;

import com.xmut.appmarket.R;
import com.xmut.appmarket.TodayItem;
import com.xmut.appmarket.model.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
*       获取APP榜单Top3
*       返回List对象
*       容量5
* */
public class AppTopDao
{
    private Connection conn=null; //打开数据库对象
    private PreparedStatement ps=null;//操作整合sql语句的对象
    private ResultSet rs=null;//查询结果的集合
    public AppTopDao()
    {
        conn= DBUtil.getConn();
    }
    public List<TodayItem> getAppList()
    {
        List<App> list=new ArrayList<App>();
        List<TodayItem> todayItems = new ArrayList<>();
        String sql="SELECT * FROM AppTable ORDER BY AppDownload DESC;";
        try {
            if(conn!=null&&(!conn.isClosed())){
                ps= (PreparedStatement) conn.prepareStatement(sql);
                if(ps!=null){
                    rs= ps.executeQuery();
                    int i=1;
                    if(rs!=null){
                        while(rs.next()&&i<=5){
                            App app=new App();
                            app.setAppID(rs.getInt("AppID"));
                            app.setAppName(rs.getString("AppName"));
                            app.setAppDownload(rs.getInt("AppDownload"));
                            app.setAppLink(rs.getString("AppLink"));
                            app.setAppPicture(rs.getString("AppPicture"));
                            list.add(app);
                            i+=1;
                        }
                    }else{
                        for(int j = 0;j<5;j++)
                            Log.d("AppTopDao","rs rs rs is null");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeAll(conn,ps,rs);//关闭相关操作
        for(App app : list){
            TodayItem item = new TodayItem(R.mipmap.ic_launcher, app.getAppName());
            todayItems.add(item);
        }
        return todayItems;
    }
}
