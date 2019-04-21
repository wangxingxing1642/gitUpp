package com.example.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRotate;
    private Button tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
    }

    private void initView() {
        btnRotate = (Button) findViewById(R.id.btnRotate);
        btnRotate.setOnClickListener(this);
        tran = (Button) findViewById(R.id.tran);
        tran.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRotate:
                Rotate();
                break;
            case R.id.tran:
                Tran();
                Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
                startActivity(intent);
                break;
        }
    }
//旋转
    public void Rotate() {
        RotateAnimation animation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animation.setDuration(1000);
        animation.setRepeatCount(10);
        animation.setRepeatMode(Animation.REVERSE);
        btnRotate.startAnimation(animation);
    }
    //平移
    private  void  Tran(){
        TranslateAnimation translateAni = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT,
                0.3f, Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0.3f);
                translateAni.setDuration(1000);
                translateAni.setRepeatCount(10);
                translateAni.setRepeatMode(Animation.REVERSE);
                tran.startAnimation(translateAni);
    }
}
