package com.example.a.traintravel.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a.traintravel.R;
import com.example.a.traintravel.adapter.TicketInfoAdapter;
import com.example.a.traintravel.model.TicketInfo;

import java.util.ArrayList;
import java.util.List;

public class TicketInfoActivity extends AppCompatActivity {
    ImageView backIV,beginTimeIV,moneyIV,timeIV;
    TextView fromTV,toTV,beforeTV,afterTV,beginTimeTV,moneyTV,timeTV;
    RecyclerView ticketInfoList;
    LinearLayout transfer,beginTimeLL,moneyLL,timeLL;

    String from,to;
    TicketInfoAdapter ticketInfoAdapter;
    List<TicketInfo> ticketInfos=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_info);
        from=getIntent().getStringExtra("from");
        to=getIntent().getStringExtra("to");
        initComponent();
        fromTV.setText(from);
        toTV.setText(to);
        beforeTV.setText(from);
        afterTV.setText(to);
        setListener();
        initRecycleView();
    }

    /**
     * wei recyclewView设置适配器
     */
    private void initRecycleView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        ticketInfoList.setLayoutManager(linearLayoutManager);
        ticketInfoAdapter=new TicketInfoAdapter(ticketInfos);
        ticketInfoList.setAdapter(ticketInfoAdapter);
    }

    /**
     * 为各组件设置点击事件
     */
    private void setListener() {
        beginTimeLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBeginTime();
            }
        });
        moneyLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoney();
            }
        });
        timeLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTime();
            }
        });
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /**
     * 初始化各组件
     */
    private void initComponent() {
        backIV=findViewById(R.id.back);
        beginTimeIV=findViewById(R.id.begin_time_image);
        moneyIV=findViewById(R.id.money_image);
        timeIV=findViewById(R.id.time_image);
        fromTV=findViewById(R.id.from);
        toTV=findViewById(R.id.to);
        beforeTV=findViewById(R.id.before);
        afterTV=findViewById(R.id.after);
        beginTimeTV=findViewById(R.id.begin_time_text);
        moneyTV=findViewById(R.id.money_text);
        timeTV=findViewById(R.id.time_text);
        ticketInfoList=findViewById(R.id.ticket_info_list);
        transfer=findViewById(R.id.transfer);
        beginTimeLL=findViewById(R.id.begin_time_ll);
        moneyLL=findViewById(R.id.money_ll);
        timeLL=findViewById(R.id.time_ll);
    }

    /**
     * 发车时间组件显示情况
     */
    private void showBeginTime(){
        beginTimeTV.setTextColor(Color.parseColor("#6BC8EC"));
        beginTimeIV.setImageResource(R.mipmap.begin_time_after);
        moneyTV.setTextColor(Color.parseColor("#000044"));
        moneyIV.setImageResource(R.mipmap.money_before);
        timeTV.setTextColor(Color.parseColor("#000044"));
        timeIV.setImageResource(R.mipmap.time_before);
    }
    /**
     * 经费最少
     */
    private void showMoney(){
        beginTimeTV.setTextColor(Color.parseColor("#000044"));
        beginTimeIV.setImageResource(R.mipmap.begin_time);
        moneyTV.setTextColor(Color.parseColor("#6BC8EC"));
        moneyIV.setImageResource(R.mipmap.money_after);
        timeTV.setTextColor(Color.parseColor("#000044"));
        timeIV.setImageResource(R.mipmap.time_before);
    }
    /**
     * 耗时最少
     */
    private void showTime(){
        beginTimeTV.setTextColor(Color.parseColor("#000044"));
        beginTimeIV.setImageResource(R.mipmap.begin_time);
        moneyTV.setTextColor(Color.parseColor("#000044"));
        moneyIV.setImageResource(R.mipmap.money_before);
        timeTV.setTextColor(Color.parseColor("#6BC8EC"));
        timeIV.setImageResource(R.mipmap.time_after);
    }
}
