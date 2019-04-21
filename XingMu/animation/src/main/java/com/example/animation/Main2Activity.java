package com.example.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initJian();
        in();
    }

    private void initView() {
        img1 = (ImageView) findViewById(R.id.img1);
    }
    //渐变
    private  void  initJian(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(3000);
        img1.startAnimation(alphaAnimation);
    }
    private  void  in(){
        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        startActivity(intent);
    }


}
