package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NicknameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView eduser;
    private SharedPreferences member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        member = getSharedPreferences("member",MODE_PRIVATE);
        findViewById(R.id.imageView).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        eduser = findViewById(R.id.nickname);
        String name = eduser.getText().toString();
        member.edit()
                .putString("user",name)
                .apply();
        Intent intent = new Intent(this,AgeActivity.class);
        startActivity(intent);
        finish();
    }



}
