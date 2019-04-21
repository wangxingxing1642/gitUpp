package com.example.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener {

    private Button shuxing_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        initView();
    }

    private void initView() {
        shuxing_btn = (Button) findViewById(R.id.shuxing_btn);

        shuxing_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shuxing_btn:
                ObjectAnimator rotation = ObjectAnimator.ofFloat(shuxing_btn, "Rotation", 0,360, 0, 360, 0);
                ObjectAnimator alpha = ObjectAnimator.ofFloat(shuxing_btn, "alpha", 1, 0.1f, 0.8f, 0, 1);
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(shuxing_btn, "scaleX", 1, 0.1f, 0.8f, 0, 1);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(shuxing_btn, "scaleY", 1, 0.1f, 0.8f, 0, 1);
                ObjectAnimator translationX = ObjectAnimator.ofFloat(shuxing_btn, "TranslationX", 0, 300, 100,500,0);
                ObjectAnimator translationY = ObjectAnimator.ofFloat(shuxing_btn, "TranslationY", 0, 300, 100,500,0);
                AnimatorSet set = new AnimatorSet();
                set.setDuration(8000);
                set.setInterpolator(new LinearInterpolator());
                set.play(alpha).with(scaleX).with(scaleY).with(translationX).with(translationY).with(rotation);
                set.start();
                break;
        }
    }
}
