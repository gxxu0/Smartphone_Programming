package kr.ac.baekseok.for_the_precious_woman;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class Calendar extends AppCompatActivity {
    public CalendarView calendar;
    public TextView memoText1, memoText2, memoText3, symptom;
    public Button add_btn;
    RadioGroup rdGroup1, rdGroup2;
    RadioButton firstRadio1, firstRadio2, firstRadio3;
    RadioButton secondRadio1, secondRadio2, secondRadio3;
    EditText edtTextInput;
    View dialogView;
    ImageView calHome,calTip,calUser,calRec;
    ScrollView scrollViewDetail;
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    String val1, val2, val3;

    public String getQuantity(View v) {
        firstRadio1 = (RadioButton) dialogView.findViewById(R.id.firstSmall);
        firstRadio2 = (RadioButton) dialogView.findViewById(R.id.firstMiddle);
        firstRadio3 = (RadioButton) dialogView.findViewById(R.id.firstALot);

        String checkQuantity = null;
        if (firstRadio1.isChecked()) {
            checkQuantity = firstRadio1.getText().toString();
        } else if (firstRadio2.isChecked()) {
            checkQuantity = firstRadio2.getText().toString();
        } else if (firstRadio3.isChecked()) {
            checkQuantity = firstRadio3.getText().toString();
        }
        return checkQuantity;
    }

    public String getPain(View v) {
        secondRadio1 = (RadioButton) dialogView.findViewById(R.id.secondSmall);
        secondRadio2 = (RadioButton) dialogView.findViewById(R.id.secondMiddle);
        secondRadio3 = (RadioButton) dialogView.findViewById(R.id.secondALot);

        String checkPain = null;
        if (secondRadio1.isChecked()) {
            checkPain = secondRadio1.getText().toString();
        } else if (secondRadio2.isChecked()) {
            checkPain = secondRadio2.getText().toString();
        } else if (secondRadio3.isChecked()) {
            checkPain = secondRadio3.getText().toString();
        }
        return checkPain;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        calendar = findViewById(R.id.calendar);
        memoText1 = findViewById(R.id.memoText1);
        memoText2 = findViewById(R.id.memoText2);
        memoText3 = findViewById(R.id.memoText3);
        edtTextInput = (EditText) findViewById(R.id.edtTextInput);
        add_btn = findViewById(R.id.add_btn);
        scrollViewDetail = (ScrollView) findViewById(R.id.scrollViewDetail);
        calHome = (ImageView) findViewById(R.id.calHome);
        calTip = (ImageView) findViewById(R.id.calTip);
        calRec = (ImageView) findViewById(R.id.calRec);
        calUser = (ImageView) findViewById(R.id.calUser);
        symptom = (TextView) findViewById(R.id.symptom);
        myHelper = new myDBHelper(this);



        calTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), tip.class);
                startActivity(intent);

            }//onClick
        }); //imgHomeTip
        calHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);

            }//onClick
        });
        calRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Recommend.class);
                startActivity(intent);
            }
        });
        calUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User.class);
                startActivity(intent);
            }
        });


        //switch되면 edit한거 보이게
        //생리여부 ON이면 추가버튼 >> 수정없애고 추가로 바꾸기
        //추가버튼 누르면 EDIT란이랑 저장버튼 뜨게
        //TEXT뷰에서 클릭하면 삭제 가능하게ㅇ
        //생리여부 off 일 때 뭐가 뜨게 해야하나 >> 우선 아무것도 안 뜨게
        Switch switchButton = findViewById(R.id.check);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) { //체크됨
                    memoText1.setVisibility(View.VISIBLE);
                    memoText2.setVisibility(View.VISIBLE);
                    memoText3.setVisibility(View.VISIBLE);
                    add_btn.setVisibility(View.VISIBLE);
                    scrollViewDetail.setVisibility(View.VISIBLE);

                    //추가버튼 누르면 memo page
                    add_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialogView = (View) View.inflate(Calendar.this, R.layout.dialogcalendar, null);
                            AlertDialog.Builder dlg = new AlertDialog.Builder(Calendar.this);
                            dlg.setTitle("월경 상세정보 입력");
                            dlg.setView(dialogView);
                            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    rdGroup1 = (RadioGroup) findViewById(R.id.firstRadioGroup);
                                    memoText1 = (TextView) findViewById(R.id.memoText1);
                                    memoText2 = (TextView) findViewById(R.id.memoText2);
                                    memoText3 = (TextView) findViewById(R.id.memoText3);
                                    String checkQuantity = getQuantity(view);
                                    String checkPain = getPain(view);
                                    edtTextInput = (EditText) dialogView.findViewById(R.id.edtTextInput);

                                    sqlDB = myHelper.getWritableDatabase();
                                    sqlDB.execSQL("INSERT INTO detailTBL VALUES('" +
                                            checkQuantity + "','" +
                                            checkPain + "','" +
                                            edtTextInput.getText().toString() + "');");
                                    sqlDB.close();

                                } //onClick


                            }); //dlg
                            dlg.setNegativeButton("취소", null);
                            dlg.show();

                        } //onClick

                    }); //add_btn

                    Cursor cursor;
                    sqlDB = myHelper.getReadableDatabase();
                    cursor = sqlDB.rawQuery("SELECT * FROM detailTBL;", null);
                    while (cursor.moveToNext()) {
                        val1 = cursor.getString(0);
                        val2 = cursor.getString(1);
                        val3 = cursor.getString(2);

                        memoText1.setText("[월경 양] " + val1);
                        memoText2.setText("[월경통 정도] " + val2);
                        memoText3.setText("[기타 정보] " + val3);

                    }
                    cursor.close();
                    sqlDB.close();
                }//if
                else { //체크되지않음

                    memoText1.setVisibility(View.INVISIBLE);
                    memoText2.setVisibility(View.INVISIBLE);
                    add_btn.setVisibility(View.INVISIBLE);
                    scrollViewDetail.setVisibility(View.INVISIBLE);
                } //else
            } //onCheckedChanged
        }); //switchButton
    } //onCreate

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "calenDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE detailTBL(checkQuantity char(10), checkPain char(10), detail CHAR(40));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS calenDB");
            onCreate(sqLiteDatabase);
        }
    }
}