package kr.ac.baekseok.for_the_precious_woman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends login{
    TextView banner1_txtView1, banner1_txtView2;
    ImageView imgHomeCalendar, imgHomeTip, imgHomeRecommend, imgHomeUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        imgHomeCalendar = (ImageView) findViewById(R.id.imgHomeCalendar);
        imgHomeTip = (ImageView) findViewById(R.id.imgHomeTip);
        imgHomeRecommend = (ImageView) findViewById(R.id.imgHomeRecommend);
        banner1_txtView1 = (TextView) findViewById(R.id.banner1_txtView1);
        banner1_txtView2 = (TextView) findViewById(R.id.banner1_txtView2);
        imgHomeUser = (ImageView) findViewById(R.id.imgHomeUser) ;

        //home배너에 표시 될 텍스트 지정
        banner1_txtView1.setText(
                "'생리'는 여성들의 월경주기를"+"\n"+" '수치스럽거나 부끄러운 것'으로 치부하는 인식에서 비롯된 것으로"+"\n"+
                "'생리적인 현상(배뇨와 배설을 떠올리게 함)'에서 따온 말이다." + "\n\n" +
                "즉, 월경을 돌려서 표현하는 것은 월경을 수치스럽거나 " +  "\n" + "숨겨야할 것으로 터부시하는 인식에서 비롯되었다."+"\n\n"+
                "월경을 부끄러운 생리현상이 아닌 새로운 생명을 창조하고"+  "\n" + "놀라운 힘의 원천임을 깨닫고 당연한걸 당당하게 말하자!");

        banner1_txtView2.setText(
                "무월경증이란, 16~24세 여성 중 8%가 겪는 일로" + "\n" +
                "월경이 규칙적이던 여성이 6개월 이상 월경이 멎을 경우 또는," + "\n" +
                "월경이 불규칙적이던 여성이 9개월 이상 월경이 멎을 경우를"+"\n"+"의미해요." + "\n\n" +
                "가장 주된 원인은, 전반적인 건강상태에요."+"\n"+"체중변화, 과도한 운동, 질병, 정신적인 스트레스/트라우마 등이"+"\n"+"원인이 될 수 있어요." +"\n\n" +
                "또한, 드물지만 장시간 비행도 월경주기가 헝크러질 수 있어요."+"\n"+"예정일이 아닌 엉뚱한 시기에 출혈이 날 수 있답니다." + "\n\n" +
                "최근에 관계를 가졌었다면, 성관계를 맺은 날로부터"+"\n"+"3주 뒤에 임신테스트기를 이용하세요." + "\n\n" +
                "몸에 에너지가 없으면 자신을 보호하기 위해"+"\n"+"알아서 월경이 멈춘다고 할 수 있어요."+"\n"+"그렇기에 건강 및 스트레스 관리, 적당한 운동으로"+"\n"+"몸을 지켜주세요:)");

        imgHomeCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);
            } //onClick
        }); //imgCalendar
        imgHomeTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), tip.class);
                startActivity(intent);

            }//onClick
        }); //imgHomeTip
        imgHomeRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Recommend.class);
                startActivity(intent);

            }//onClick
        }); //imgHomeRecommend
        imgHomeUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User.class);
                startActivity(intent);
            }
        });
    }
}