package com.xmut.appmarket.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xmut.appmarket.R;

import java.util.List;

public class HotSearchAdapter extends RecyclerView.Adapter<HotSearchAdapter.ViewHolder>{
    private List<App> appList;
    public HotSearchAdapter(List<App> list){
        appList = list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hotAppName;
        public ViewHolder( View view) {
            super(view);
            hotAppName = (TextView) view.findViewById(R.id.hotapp_name);

        }
    }
    public HotSearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotsearch_item
                ,parent,false);
        final HotSearchAdapter.ViewHolder holder = new HotSearchAdapter.ViewHolder(view);
        holder.hotAppName.setOnClickListener(new View.OnClickListener(){
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
    public void onBindViewHolder(HotSearchAdapter.ViewHolder holder, int position) {
        App app =appList.get(position);

        holder.hotAppName.setText(app.getAppName());


    }
    public int getItemCount(){
        return appList.size();
    }
}
