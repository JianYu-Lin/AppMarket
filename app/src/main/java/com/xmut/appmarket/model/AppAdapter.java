package com.xmut.appmarket.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xmut.appmarket.R;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder>{
    private List<App> appList;
    public AppAdapter(List<App> list){
        appList = list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView appImage;
        TextView appName;
        TextView appIntro;
        public ViewHolder(View view){
            super(view);
            appImage = (ImageView) view.findViewById(R.id.app_im);
            appName = (TextView) view.findViewById(R.id.app_name);
            appIntro = (TextView) view.findViewById(R.id.app_intro);
        }
    }
    public AppAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item
                ,parent,false);
        final AppAdapter.ViewHolder holder = new AppAdapter.ViewHolder(view);
        holder.appImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position =  holder.getAdapterPosition();
                App app = appList.get(position);
                Toast.makeText(v.getContext(),"You Clicked item "+app.getAppName(),
                        Toast.LENGTH_SHORT).show();

            }
        });
        holder.appName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position =  holder.getAdapterPosition();
                App app = appList.get(position);
                Toast.makeText(v.getContext(),"You Clicked item "+app.getAppName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }
    public void onBindViewHolder(AppAdapter.ViewHolder holder, int position) {
        App app =appList.get(position);

        holder.appImage.setImageResource(app.getAppID());

        holder.appName.setText(app.getAppName());
        holder.appIntro.setText(app.getAppIntro());


    }
    public int getItemCount(){
        return appList.size();
    }
}
