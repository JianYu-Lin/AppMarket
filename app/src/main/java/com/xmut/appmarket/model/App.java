package com.xmut.appmarket.model;

public class App {

    private int appID; //应用ID
    private String appName;//应用名称
    private String appLink;//应用链接
    private int appDownload;//下载次数
    private String appPicture;//应用图片
    private String appIntro;//介绍
    public App(){
        super();
    }
    public App(int ID,String name,String intro){
        appID = ID;
        appName = name;
        appIntro = intro;
    }
    public void setAppIntro(String appIntro) {
        this.appIntro = appIntro;
    }

    public String getAppIntro() {
        return appIntro;
    }

    public String getAppName()
    {
        return appName;
    }
    public String getAppLink()
    {
        return appLink;
    }
    public String getAppPicture()
    {
        return appPicture;
    }
    public int getAppID()
    {
        return appID;
    }
    public int getAppDownload()
    {
        return appDownload;
    }

    //
    public void setAppID(int AppID)
    {
        this.appID =AppID;
    }
    public void setAppName(String  appName)
    {
        this.appName =appName;
    }
    public void setAppLink(String AppLink)
    {
        this.appLink =AppLink;
    }
    public void setAppDownload(int AppDownload)
    {
        this.appDownload =AppDownload;
    }
    public void setAppPicture(String AppPicture)
    {
        this.appPicture =AppPicture;
    }
}
