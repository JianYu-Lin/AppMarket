package com.xmut.appmarket;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xmut.appmarket.R;
import com.xmut.appmarket.model.App;
import com.xmut.appmarket.model.HotSearchAdapter;

import java.util.ArrayList;
import java.util.List;


public class FragmentThree extends Fragment {
    List<App> appList;
    EditText editText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_three,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_hotsearch);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        HotSearchAdapter adapter = new HotSearchAdapter(getAppList());
        recyclerView.setAdapter(adapter);
        editText = view.findViewById(R.id.search_text);
        initListener();


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
    private void initListener(){
        if(editText!=null){
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if(actionId == EditorInfo.IME_ACTION_SEARCH){
                        //以下为点击回车后的事件
                        String searchText = editText.getText().toString();
                        Toast.makeText(getContext(),"search for:"+searchText,
                                Toast.LENGTH_SHORT).show();

                        //收起键盘
                        InputMethodManager imm = (InputMethodManager) getActivity().
                                getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                        return true;
                    }
                    return false;
                }
            });
        }

        //点击键盘和editText外区域收起键盘
        getActivity().getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (getActivity().getCurrentFocus() != null) {
                   imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                } else {
                    imm.hideSoftInputFromWindow((getActivity().findViewById(android.R.id.content)).getWindowToken(), 0);
                }
                return false;
            }
        });

    }
}