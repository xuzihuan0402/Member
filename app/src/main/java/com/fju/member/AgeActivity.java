package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AgeActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        member = getSharedPreferences("member",MODE_PRIVATE);
        findViewById(R.id.imageViewage).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        TextView edage = findViewById(R.id.edage);
        String age = edage.getText().toString();
        member.edit()
                .putString("age",age)
                .apply();
        Intent intent = new Intent(this,GenderActivity.class);
        startActivity(intent);
        finish();
    }


}
