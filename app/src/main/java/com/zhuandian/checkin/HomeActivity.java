package com.zhuandian.checkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.tv_figurer).setOnClickListener(this);
        findViewById(R.id.tv_map).setOnClickListener(this);
        findViewById(R.id.tv_number).setOnClickListener(this);
        findViewById(R.id.tv_voice).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_figurer:
                Toast.makeText(this, "功能暂未实现...", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_map:
                Toast.makeText(this, "功能暂未实现...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_number:
                Toast.makeText(this, "功能暂未实现...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_voice:
                startActivity(new Intent(this,IatActivity.class));
                break;
        }
    }
}
