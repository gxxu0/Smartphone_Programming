package kr.ac.baekseok.for_the_precious_woman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class tip extends AppCompatActivity {
    ImageView imgTipHome, imgTipCalendar, imgTipRec, imgTipUser;
    RecyclerView recyclerView;
    String s1[];

    int images[]={R.drawable.appetite, R.drawable.leg, R.drawable.back_pain, R.drawable.cramps, R.drawable.condom, R.drawable.pills};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip);
        imgTipHome = (ImageView) findViewById(R.id.imgTipHome);
        imgTipCalendar = (ImageView) findViewById(R.id.imgTipCalendar);
        imgTipRec = (ImageView) findViewById(R.id.imgTipRec);
        imgTipUser = (ImageView) findViewById(R.id.imgTipUser);
        imgTipHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });
        imgTipCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);

            }
        });
        imgTipRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Recommend.class);
                startActivity(intent);

            }
        });
        imgTipUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User.class);
                startActivity(intent);

            }
        });


        recyclerView  = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.pcu_name); //pms >> pcuName



        tipAdapter myAdapter = new tipAdapter(this, s1, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
