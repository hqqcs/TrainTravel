package com.example.a.traintravel;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a.traintravel.fragment.MyFragment;
import com.example.a.traintravel.fragment.SearchTrainFragment;

public class MainActivity extends AppCompatActivity {
    private LinearLayout homeLL,myLL;
    private ImageView homeIV,myIV;
    private TextView homeTV,myTV;
    private FrameLayout frameLayout;
    private Fragment homeFragment,myFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        initComponent();
        setListener();
        replaceFragment(homeFragment);
        homeIV.setImageResource(R.mipmap.search_after);
        homeTV.setTextColor(Color.parseColor("#6BC8EC"));
        myIV.setImageResource(R.mipmap.my_before);
        myTV.setTextColor(Color.parseColor("#000044"));
    }

    /**
     * 为各组件设置点击事件
     */
    private void setListener() {
        homeLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(homeFragment);
                homeIV.setImageResource(R.mipmap.search_after);
                homeTV.setTextColor(Color.parseColor("#6BC8EC"));
                myIV.setImageResource(R.mipmap.my_before);
                myTV.setTextColor(Color.parseColor("#000044"));
            }
        });
        myLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(myFragment);
                myIV.setImageResource(R.mipmap.my_after);
                homeTV.setTextColor(Color.parseColor("#6BC8EC"));
                homeIV.setImageResource(R.mipmap.search_before);
                homeTV.setTextColor(Color.parseColor("#000044"));
            }
        });
    }

    /**
     * 初始化各组件
     */
    private void initComponent() {
        homeLL= findViewById(R.id.home_ll);
        myLL=findViewById(R.id.my_ll);
        homeIV=findViewById(R.id.home_image);
        myIV=findViewById(R.id.my_image);
        homeTV=findViewById(R.id.home_text);
        myTV =findViewById(R.id.my_text);
        frameLayout=findViewById(R.id.fragment);
        homeFragment=new SearchTrainFragment();
        myFragment=new MyFragment();
    }
    /**
     * fragment替换事件
     *
     * @param fragment
     */
    private void replaceFragment(Fragment fragment) {
        FragmentManager ft=getSupportFragmentManager();
        FragmentTransaction ftr=ft.beginTransaction();
        ftr.replace(R.id.fragment,fragment);
        ftr.commit();
    }

}
