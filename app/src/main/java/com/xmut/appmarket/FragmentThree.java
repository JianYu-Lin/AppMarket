package com.xmut.appmarket;

import android.app.Activity;
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
import com.xmut.appmarket.model.SearchResultAdapter;

import java.util.ArrayList;
import java.util.List;


public class FragmentThree extends Fragment {
    List<App> appList;
    EditText editText;
    TextView titleText;
    TextView titleText2;
    TextView cancelText;
    RecyclerView recyclerHot;
    HotSearchAdapter hotAdapter;
    SearchResultAdapter searchResultAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_three,container,false);
        recyclerHot = (RecyclerView) view.findViewById(R.id.recycler_hotsearch);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerHot.setLayoutManager(layoutManager);
        hotAdapter = new HotSearchAdapter(getAppList());
        recyclerHot.setAdapter(hotAdapter);
        editText = view.findViewById(R.id.search_text);
        titleText = view.findViewById(R.id.search_title);
        titleText2 = view.findViewById(R.id.search_title2);
        cancelText = view.findViewById(R.id.text_cancel);
        cancelText.setVisibility(View.GONE);
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
            //EditeText焦点状态改变事件
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        titleText.setVisibility(View.GONE);
                        cancelText.setVisibility(View.VISIBLE);
                    }else{
                        titleText.setVisibility(View.VISIBLE);
                        closeSoftInput();
                    }
                }
            });
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if(actionId == EditorInfo.IME_ACTION_SEARCH){
                        //以下为点击回车后的事件
                        //获取输入的字符串
                        String searchText = editText.getText().toString();
                        Toast.makeText(getContext(),"search for:"+searchText,
                                Toast.LENGTH_SHORT).show();
                        titleText2.setVisibility(View.GONE);
                        //recyclerHot.setVisibility(View.GONE);
                        //获取搜索结果列表
                        searchResultAdapter = new SearchResultAdapter(getAppList());
                        recyclerHot.setAdapter(searchResultAdapter);
                        //收起键盘
                        closeSoftInput();
                        return true;
                    }
                    return false;
                }
            });
        }
        //取消按钮点击事件
        cancelText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelText.setVisibility(View.GONE);
                editText.setText("");
                editText.clearFocus();
                titleText2.setVisibility(View.VISIBLE);
                recyclerHot.setAdapter(hotAdapter);
            }
        });
        //点击键盘和editText外区域收起键盘
        getActivity().getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (getActivity().getCurrentFocus() != null) {
                   imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                    editText.clearFocus();
                } else {
                    imm.hideSoftInputFromWindow((getActivity().findViewById(android.R.id.content)).getWindowToken(), 0);
                    editText.clearFocus();
                }
                return false;
            }
        });

    }
    //关闭键盘
    public void closeSoftInput(){
        InputMethodManager imm = (InputMethodManager) getActivity().
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if(getActivity().getCurrentFocus()!=null){
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus()
                    .getWindowToken(), 0);
        }else {
            imm.hideSoftInputFromWindow((getActivity()
                    .findViewById(android.R.id.content)).getWindowToken(), 0);
        }

    }


}