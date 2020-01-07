package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GenderActivity extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        member = getSharedPreferences("member",MODE_PRIVATE);
        findViewById(R.id.imageViewgen).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView edgen = findViewById(R.id.edgen);
        String gen = edgen.getText().toString();
        member.edit()
                .putString("gen",gen)
                .apply();
        finish();

    }


}
