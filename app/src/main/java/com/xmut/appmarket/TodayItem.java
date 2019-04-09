package com.xmut.appmarket;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.URL;

public class TodayItem {
    private int imageID;
    private String imageUrl;
    private  String text;
    private Bitmap pngImage;
    public TodayItem(int id,String t){
        imageID =id;
        text = t;
    }
    public int getImageID(){
        return imageID;
    }
    public Bitmap getPngImage() throws IOException {
        URL url = new URL(imageUrl);
        pngImage = BitmapFactory.decodeStream(url.openStream());
        return pngImage;
    }
    public String getText(){
        return text;
    }
}
