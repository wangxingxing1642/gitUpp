package com.example.animation;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

//王杏杏   1808A
public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private ScaleAnimation mScaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        initAn();//缩放
        init();

    }
    //缩放
    private  void  initAn(){
        mScaleAnimation = new ScaleAnimation(0, 2, 0, 2,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        mScaleAnimation.setDuration(5000);
        mScaleAnimation.setFillAfter(true);
        img.setAnimation(mScaleAnimation);
    }
    private  void  init(){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}
