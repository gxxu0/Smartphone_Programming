package kr.ac.baekseok.for_the_precious_woman;

import android.os.Bundle;

import androidx.annotation.Nullable;

public class tipCardviewDt extends tip{
    String s1[];

    int images[]={R.drawable.appetite, R.drawable.leg, R.drawable.back_pain, R.drawable.cramps, R.drawable.condom, R.drawable.pills};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_cardview_detail);


        s1 = getResources().getStringArray(R.array.pcu_name);



    }
}
