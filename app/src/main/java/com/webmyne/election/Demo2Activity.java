package com.webmyne.election;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.webmyne.election.custom.Animation;
import com.webmyne.election.custom.AnimationListener;
import com.webmyne.election.custom.BounceAnimation;
import com.webmyne.election.custom.SlideInUnderneathAnimation;
import com.webmyne.election.custom.SlideOutAnimation;


public class Demo2Activity extends AppCompatActivity {

    private ImageView imgRecipt;
    private ImageView imgMachine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        init();
        actionListener();
    }

    private void init() {
        imgRecipt = (ImageView) findViewById(R.id.imgReceipt);
        imgMachine = (ImageView) findViewById(R.id.imgMachine);
    }

    private void actionListener() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgRecipt.setVisibility(View.VISIBLE);
                new SlideInUnderneathAnimation(imgRecipt)
                        .setDirection(Animation.DIRECTION_DOWN)
                        .setDuration(2000)
                        .setListener(new AnimationListener() {
                            @Override
                            public void onAnimationEnd(Animation animation) {
                                slideOut();
                            }
                        })
                        .animate();
            }
        }, 2000);

    }

    private void slideOut() {
        new SlideOutAnimation(imgMachine)
                .setDirection(Animation.DIRECTION_RIGHT)
                .setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        bounceAnimation();
                    }
                })
                .animate();
    }


    private void bounceAnimation() {
        new BounceAnimation(imgRecipt)
                .setNumOfBounces(3)
                .setDuration(Animation.DURATION_SHORT)
                .animate();
    }

}
