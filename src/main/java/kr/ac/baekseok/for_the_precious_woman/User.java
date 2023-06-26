package kr.ac.baekseok.for_the_precious_woman;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class User extends Home {
    TextView userName;
    Button userLogout;
    ImageView imgUserCalendar,imgUserTip ,imgUserHome,imgUserRec;
    String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        Cursor cursor;
        sqlDB = myHelper.getReadableDatabase();
        cursor = sqlDB.rawQuery("SELECT uName FROM Join_info;", null);
        userName = (TextView) findViewById(R.id.userName);

        while(cursor.moveToNext()) {
            val = cursor.getString(0);
        }
        userName.setText(val + " 님");
        cursor.close();
        sqlDB.close();

        userLogout = (Button) findViewById(R.id.userLogout);

        userLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "로그아웃 되었습니다.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplication(), login.class);
                startActivity(intent);
            }
        });


        imgUserCalendar = (ImageView) findViewById(R.id.imgUserCalendar);
        imgUserTip = (ImageView) findViewById(R.id.imgUserTip);
        imgUserHome = (ImageView) findViewById(R.id.imgUserHome);
        imgUserRec = (ImageView) findViewById(R.id.imgUserRec);

        //하단바
        imgUserCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);
            } //onClick
        }); //imgCalendar
        imgUserTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), tip.class);
                startActivity(intent);

            }//onClick
        }); //imgHomeTip
        imgUserHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);

            }//onClick
        }); //imgHomeRecommend
        imgUserRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Recommend.class);
                startActivity(intent);
            }
        });

    }
}
