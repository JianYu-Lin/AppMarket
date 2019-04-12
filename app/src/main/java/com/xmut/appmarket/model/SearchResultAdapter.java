package com.xmut.appmarket.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xmut.appmarket.R;
import com.xmut.appmarket.TodayItem;
import com.xmut.appmarket.TodayItemAdapter;

import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder>{

    private List<App> appList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView appImage;
        TextView appName;
        TextView appIntro;
        CardView appTouched;
        public ViewHolder(View view){
            super(view);
            appImage = (ImageView) view.findViewById(R.id.result_im);
            appName = (TextView) view.findViewById(R.id.result_name);
            appIntro = (TextView) view.findViewById(R.id.result_intro);
            appTouched = (CardView) view.findViewById(R.id.result_item);
        }
    }
    public SearchResultAdapter(List<App> list){
        appList = list;
    }
    public SearchResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_item
                ,parent,false);
        final SearchResultAdapter.ViewHolder holder = new SearchResultAdapter.ViewHolder(view);
        //获取点击卡片事件
        holder.appTouched.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        App app =appList.get(position);

        holder.appImage.setImageResource(app.getAppID());

        holder.appName.setText(app.getAppName());
        holder.appIntro.setText(app.getAppIntro());
    }

    public int getItemCount(){
        return appList.size();
    }
}
