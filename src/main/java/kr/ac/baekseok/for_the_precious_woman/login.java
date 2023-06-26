package kr.ac.baekseok.for_the_precious_woman;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends sign {
    TextView txtGoSignUp;
    EditText logId, logPw;
    Button logBtn;
    int IdFlag = 0;
    int PwFlag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        logId = (EditText) findViewById(R.id.logId);
        logPw = (EditText) findViewById(R.id.logPw);
        logBtn = (Button) findViewById(R.id.logBtn);

        txtGoSignUp = (TextView) findViewById(R.id.txtGoSignUp);
        txtGoSignUp.setPaintFlags(txtGoSignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtGoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), sign.class);
                startActivity(intent);
            }
        }); //txtGoSignUp

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor;
                sqlDB = myHelper.getReadableDatabase();
                cursor = sqlDB.rawQuery("SELECT uId, uPassword, uName FROM Join_info;", null);
                String edt1 = null;
                String pw1 = null;
                String edt2 = null;
                String pw2 = null;
                IdFlag = 0;
                PwFlag = 0;

                while(cursor.moveToNext()){
                    edt2 = cursor.getString(0);
                    pw2 = cursor.getString(1);
                    edt1 = logId.getText().toString();
                    pw1 = logPw.getText().toString();
                    if(edt2.equals(edt1)){
                        IdFlag = 1;
                        if(pw2.equals(pw1)){
                            PwFlag = 1;
                            String name = cursor.getString(2);
                            Toast.makeText(getApplicationContext(), name + "님 안녕하세요!", Toast.LENGTH_LONG).show();
                            //Toast.makeText(getApplicationContext(), "로그인 완료", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Home.class);
                            startActivity(intent);
                        } //if
                        else{
                            Toast.makeText(getApplicationContext(), "비밀번호를 다시 입력해주세요.", Toast.LENGTH_LONG).show();
                        } //else
                    } //if
                    else{
//                        Intent intent = new Intent(getApplicationContext(), Main.class);
//                        startActivity(intent);
                    }
                } //while
                if(IdFlag == 0 && PwFlag == 0){
                    Toast.makeText(getApplicationContext(), "아이디를 다시 입력해주세요.", Toast.LENGTH_LONG).show();
                    cursor.close();
                    sqlDB.close();
                } //if
            } //onClick
        }); //logBtn
    } //onCreate
}