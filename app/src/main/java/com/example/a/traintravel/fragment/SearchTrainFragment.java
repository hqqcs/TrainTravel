package com.example.a.traintravel.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.traintravel.R;
import com.example.a.traintravel.activity.ChoiceCityActivity;
import com.example.a.traintravel.activity.TicketInfoActivity;
import com.example.a.traintravel.datepicker.CustomDatePicker;
import com.example.a.traintravel.datepicker.DateFormatUtils;

import java.util.Calendar;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchTrainFragment extends Fragment {
    TextView placeOfDeparture,destination,date;
    ImageView exchange;
    Button searchTicket;
    View view;
    private CustomDatePicker mDatePicker;

    public SearchTrainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_search_train, container, false);
        // Inflate the layout for this fragment

        initComponent();
        initDatePicker();
        setListener();
        return view;
    }

    /**
     * 为各组件设置点击事件
     */
    private void setListener() {
        placeOfDeparture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),ChoiceCityActivity.class);
                startActivityForResult(intent,1);
            }
        });
        destination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ChoiceCityActivity.class);
                startActivityForResult(intent,2);
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatePicker.show(date.getText().toString());
            }
        });
        searchTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),TicketInfoActivity.class);
                intent.putExtra("from",placeOfDeparture.getText().toString());
                intent.putExtra("to",destination.getText().toString());
                startActivity(intent);
            }
        });
    }

    /**
     * 初始化各组件
     */
    private void initComponent() {
        placeOfDeparture=view.findViewById(R.id.place_of_departure);
        destination=view.findViewById(R.id.destination);
        exchange=view.findViewById(R.id.exchange);
        searchTicket=view.findViewById(R.id.search_ticket);
        date=view.findViewById(R.id.date);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String city=data.getStringExtra("city");
                    placeOfDeparture.setText(city);
                }
            case 2:
                if (resultCode == RESULT_OK){
                    String city=data.getStringExtra("city");
                    destination.setText(city);
                }
        }
    }
    //初始化日期选择器
    private void initDatePicker() {
        long beginTimestamp = DateFormatUtils.str2Long("2020-01-01", false);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 60);
        long endTimestamp = c.getTimeInMillis();
        long nowTimestamp=System.currentTimeMillis();

        date.setText(DateFormatUtils.long2Str(nowTimestamp, false));

        // 通过时间戳初始化日期，毫秒级别
        mDatePicker = new CustomDatePicker(getContext(), new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                date.setText(DateFormatUtils.long2Str(timestamp, false));
            }
        }, beginTimestamp, endTimestamp);
        // 不允许点击屏幕或物理返回键关闭
        mDatePicker.setCancelable(false);
        // 不显示时和分
        mDatePicker.setCanShowPreciseTime(false);
        // 不允许循环滚动
        mDatePicker.setScrollLoop(false);
        // 不允许滚动动画
        mDatePicker.setCanShowAnim(false);
    }
}
