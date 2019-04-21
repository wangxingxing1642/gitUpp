package com.example.animation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button dong;
    private Button ting;
    private ImageView iv;
    private AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        inii();
    }

    private void initView() {
        dong = (Button) findViewById(R.id.dong);
        ting = (Button) findViewById(R.id.ting);
        iv = (ImageView) findViewById(R.id.iv);

        dong.setOnClickListener(this);
        ting.setOnClickListener(this);
        drawable = (AnimationDrawable) iv.getBackground();
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawable.start();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dong:
                break;
            case R.id.ting:
                break;
        }
    }
    private  void  inii(){
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
        startActivity(intent);
    }


}
