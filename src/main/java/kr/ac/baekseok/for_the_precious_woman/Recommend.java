package kr.ac.baekseok.for_the_precious_woman;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recommend extends TabActivity {
    String postStr, descStr, manStr;
    int pos;
    ImageView imgRecHome,imgRecCalendar, imgRecTip, imgRecUser;
    RecyclerView recRecyclerView1,recRecyclerView2,recRecyclerView3;
    String s1[];
    String s1_1[];
    String s2[];
    String s2_1[];
    String s3[];
    String s3_1[];

    int images1[]={R.drawable.happy_moon_day1,
            R.drawable.happy_moon_day2,
            R.drawable.happy_moon_day3,
            R.drawable.the_forest,
            R.drawable.blueblue,
            R.drawable.naturalcotton,
            R.drawable.tempo1,
            R.drawable.goodfeel

    };
    int images2[]={R.drawable.contraception1,
            R.drawable.contraception1_1,
            R.drawable.contraception1_2,
            R.drawable.contraception1_3,
            R.drawable.contraception1_4,
            R.drawable.contraception1_5,
            R.drawable.contraception2_1,
            R.drawable.contraception2_2,
            R.drawable.contraception2_3,
            R.drawable.contraception2_4,
            R.drawable.contraception2_5,
            R.drawable.contraception2_6,
            R.drawable.contraception3_1,
            R.drawable.contraception3_2,
            R.drawable.contraception1_1,
            R.drawable.contraception4
    };
    int images3[]={R.drawable.vagina1_1,
            R.drawable.vagina1_2,
            R.drawable.vagina1_3,
            R.drawable.vagina1_4,
            R.drawable.vagina2_1,
            R.drawable.vagina3_1,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendation);
        imgRecHome = (ImageView) findViewById(R.id.imgRecHome);
        imgRecCalendar = (ImageView) findViewById(R.id.imgRecCalendar);
        imgRecTip = (ImageView) findViewById(R.id.imgRecTip);
        imgRecUser = (ImageView) findViewById(R.id.imgRecUser);

        imgRecHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });
        imgRecCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);

            }
        });
        imgRecTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), tip.class);
                startActivity(intent);

            }
        });
        imgRecUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User.class);
                startActivity(intent);

            }
        });


        TabHost tabHost = getTabHost();//tabHost 인스턴스 생성 메소드 / 클래스 추가

        //TabHost에 들어가는 tab 안내 글자 (태그 표시구분) 등 tabhost 구성요소를 사용하기 위한 TabSpec이라는 클래스의 인스턴스 생성
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("TAG1").setIndicator("월경용품");
        tabSpec1.setContent(R.id.tabMenstruation);
        tabHost.addTab(tabSpec1);
        recRecyclerView1  = findViewById(R.id.recRecyclerView1);
        s1 = getResources().getStringArray(R.array.menstruation_name);
        s1_1 = getResources().getStringArray(R.array.menstruation_contents);

        RecommendAdapter myAdapter1 = new RecommendAdapter(this, s1,s1_1, images1);
        recRecyclerView1.setAdapter(myAdapter1);
        recRecyclerView1.setLayoutManager(new LinearLayoutManager(this));



        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("TAG2").setIndicator("피임용품");
        tabSpec2.setContent(R.id.tabContraception);
        tabHost.addTab(tabSpec2);
        recRecyclerView2  = findViewById(R.id.recRecyclerView2);
        s2 = getResources().getStringArray(R.array.contraception_name);
        s2_1 = getResources().getStringArray(R.array.contraception_contents);

        RecommendAdapter myAdapter2 = new RecommendAdapter(this, s2,s2_1, images2);
        recRecyclerView2.setAdapter(myAdapter2);
        recRecyclerView2.setLayoutManager(new LinearLayoutManager(this));



        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("TAG3").setIndicator("질 건강 용품");
        tabSpec3.setContent(R.id.tabVagina);
        tabHost.addTab(tabSpec3);
        recRecyclerView3  = findViewById(R.id.recRecyclerView3);
        s3 = getResources().getStringArray(R.array.vagina_name);
        s3_1 = getResources().getStringArray(R.array.vagina_contents);

        RecommendAdapter myAdapter3 = new RecommendAdapter(this, s3,s3_1, images3);
        recRecyclerView3.setAdapter(myAdapter3);
        recRecyclerView3.setLayoutManager(new LinearLayoutManager(this));

        //첫번째 tab content가 보여지게 설정
        tabHost.setCurrentTab(0); //0번째 index값, 빨간색 화면이 처음에 보이게 설정.


    } //onCreate()

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

