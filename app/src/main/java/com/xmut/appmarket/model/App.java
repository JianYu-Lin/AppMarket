package com.xmut.appmarket.model;

public class App {

    private int AppID; //应用ID
    private String Appname;//应用名称
    private String AppLink;//应用链接
    private int AppDownload;//下载次数
    private String AppPicture;//应用图片

    public String getAppName()
    {
        return Appname;
    }
    public String getAppLink()
    {
        return AppLink;
    }
    public String getAppPicture()
    {
        return AppPicture;
    }
    public int getAppID()
    {
        return AppID;
    }
    public int getAppDownload()
    {
        return AppDownload;
    }

    //
    public void setAppID(int AppID)
    {
        this.AppID=AppID;
    }
    public void setAppName(String  appName)
    {
        this.Appname=appName;
    }
    public void setAppLink(String AppLink)
    {
        this.AppLink=AppLink;
    }
    public void setAppDownload(int AppDownload)
    {
        this.AppDownload=AppDownload;
    }
    public void setAppPicture(String AppPicture)
    {
        this.AppPicture=AppPicture;
    }
}
