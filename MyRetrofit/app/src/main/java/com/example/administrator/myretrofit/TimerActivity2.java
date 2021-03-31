package com.example.administrator.myretrofit;

import android.os.Bundle;
import android.widget.ListView;

import com.example.administrator.myretrofit.adapter.MiaoShaBean;
import com.example.administrator.myretrofit.adapter.TimerAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity2 extends AppCompatActivity {

    private ListView mListView;
    private List<MiaoShaBean> mList;
    private TimerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer2);
        mListView = (ListView)findViewById(R.id.lv_timer);
        //初始化数据
        mList = new ArrayList<>();
        mList.add(new MiaoShaBean("毛衣", "2021-04-01", "5","360"));
        mList.add(new MiaoShaBean("鞋子", "2021-04-02", "","460"));
        mList.add(new MiaoShaBean("T恤", "2021-04-05", "9","160"));
        mList.add(new MiaoShaBean("羽绒服", "2021-04-01", "3","598"));
        mList.add(new MiaoShaBean("鞋子", "2021-04-02", "","460"));
        mList.add(new MiaoShaBean("鞋子", "2021-04-02", "","460"));
        mList.add(new MiaoShaBean("鞋子", "2021-04-02", "","460"));
        mAdapter = new TimerAdapter(this, mList);
        //设置适配器
        mListView.setAdapter(mAdapter);

    }
}