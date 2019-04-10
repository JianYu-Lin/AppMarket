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
import com.xmut.appmarket.model.HotSearchAdapter;

import java.util.ArrayList;
import java.util.List;


public class FragmentThree extends Fragment {
    List<App> appList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_three,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_hotsearch);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        HotSearchAdapter adapter = new HotSearchAdapter(getAppList());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<App> getAppList() {
        appList = new ArrayList<>();
        for(int i = 0;i<6;i++){
            App app = new App(R.mipmap.ic_launcher,"app"+i,"111");
            appList.add(app);
        }
        return appList;
    }
}