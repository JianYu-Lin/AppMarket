package com.xmut.appmarket;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xmut.appmarket.R;
import com.xmut.appmarket.model.App;
import com.xmut.appmarket.model.AppAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FragmentTwo extends Fragment {
    List<App> appList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_two,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_two);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        AppAdapter adapter = new AppAdapter(getAppList());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public List<App> getAppList() {
        appList = new ArrayList<>();
        for(int i=0;i<10;i++){
            App app = new App(R.mipmap.ic_launcher,"app"+i,getRandomLengthName("app"+i));
            appList.add(app);
        }
        return appList;
    }
    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i<length;i++){
            builder.append(name);
        }
        return  builder.toString();
    }
}