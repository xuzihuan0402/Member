package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int RC_CODE = 110;
    private Intent intent;
    private SharedPreferences member;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_CODE){
            TextView edname = findViewById(R.id.ed_name);
            TextView edage= findViewById(R.id.ed_age);
            TextView edgen = findViewById(R.id.ed_gen);
            edname.setText(member.getString("user",null));
            edage.setText(member.getString("age",null));
            edgen.setText(member.getString("gen",null));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        member = getSharedPreferences("member",MODE_PRIVATE);
        member.edit().clear().commit();
        if(member.getString("user",null)==null || member.getString("age",null)==null || member.getString("gen",null)==null){
            intent = new Intent(this,NicknameActivity.class);
            startActivityForResult(intent,RC_CODE);
        }





    }
}
