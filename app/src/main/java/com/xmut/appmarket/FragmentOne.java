package com.xmut.appmarket;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xmut.appmarket.Dao.AppTopDao;
import com.xmut.appmarket.R;
import com.xmut.appmarket.model.App;

import java.util.ArrayList;
import java.util.List;


public class FragmentOne extends Fragment {
    List<TodayItem> itemList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        TodayItemAdapter adapter = new TodayItemAdapter(getItemList());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public List<TodayItem> getItemList(){
        itemList = new ArrayList<>();
          AppTopDao topDao = new AppTopDao();
        itemList = topDao.getAppList();
        if(itemList.size()==0){
            for(int i = 0;i<5;i++)
                Log.d("FragmentOne","list is null");
        }
        for(int i = 0;i<5;i++){
            TodayItem item = new TodayItem(R.mipmap.ic_launcher, "app"+(i+1));
            itemList.add(item);
        }
        return itemList;
    }




}