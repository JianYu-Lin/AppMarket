package com.xmut.appmarket;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class TodayItemAdapter extends RecyclerView.Adapter<TodayItemAdapter.ViewHolder>{
    private List<TodayItem> itemList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.iv);
            textView = (TextView) view.findViewById(R.id.tv);
        }
    }
    public TodayItemAdapter(List<TodayItem> list){
        itemList = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.today_item
        ,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position =  holder.getAdapterPosition();
                TodayItem itemClicked = itemList.get(position);
                Toast.makeText(v.getContext(),"You Clicked item "+itemClicked.getText(),
                        Toast.LENGTH_SHORT).show();

            }
        });
        holder.textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position =  holder.getAdapterPosition();
                TodayItem itemClicked = itemList.get(position);
                Toast.makeText(v.getContext(),"You Clicked item "+itemClicked.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }
    public void onBindViewHolder(ViewHolder holder,int position) {
        TodayItem item =itemList.get(position);

        holder.imageView.setImageResource(item.getImageID());

        holder.textView.setText(item.getText());


    }
    public int getItemCount(){
        return itemList.size();
    }
}
