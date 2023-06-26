package kr.ac.baekseok.for_the_precious_woman;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class sign extends Activity {
    EditText edtName, edtId, edtPw, edtPwCheck, edtEmail, edtPhoneNumber;
    Button  btnSignup;
    CheckBox chkAll, chkFirst, chkSecond, chkThird;
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);

        edtName = (EditText) findViewById(R.id.edtName);
        edtId = (EditText) findViewById(R.id.edtId);
        edtPw = (EditText) findViewById(R.id.edtPw);
        edtPwCheck = (EditText) findViewById(R.id.edtPwCheck);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);
        btnSignup = (Button) findViewById(R.id.btnSignup);

        myHelper = new myDBHelper(this);

        chkAll = (CheckBox) findViewById(R.id.chkAll) ;
        chkFirst = (CheckBox) findViewById(R.id.chkFirst) ;
        chkSecond = (CheckBox) findViewById(R.id.chkSecond) ;
        chkThird = (CheckBox) findViewById(R.id.chkThird) ;
        chkAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkAll.isChecked()){
                    chkFirst.setChecked(true);
                    chkSecond.setChecked(true);
                    chkThird.setChecked(true);
                }else{
                    chkFirst.setChecked(false);
                    chkSecond.setChecked(false);
                    chkThird.setChecked(false);

                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO Join_info VALUES ('"+
                        edtName.getText().toString()+"','"+
                        edtId.getText().toString()+"','"+
                        edtPw.getText().toString()+"','"+
                        edtPwCheck.getText().toString()+"','"+
                        edtEmail.getText().toString()+"','"+
                        edtPhoneNumber.getText().toString()+"');");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplication(), login.class);
                startActivity(intent);
            } //onClick
        }); //btnSignup
    } //onCreate

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context){
            super(context, "forThe", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(
                    "CREATE TABLE Join_info(" +
                            "uName char(10), " +
                            "uId char(20) PRIMARY KEY, " +
                            "uPassword char(20), " +
                            "uPasswordCheck char(20), " +
                            "uEmail char(40), " +
                            "uPhoneNumber INTEGER);"
            );
        } //onCreate
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS forThe");
            onCreate(sqLiteDatabase);
        } //onUpgrade
    } //myDBHelper
}
