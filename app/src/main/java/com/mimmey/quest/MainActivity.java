package com.mimmey.quest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    ImageView mImageView;
    ViewGroup mRoot;
    TextView mTime;
    private int mXDelta;
    ImageView mBar;
    ImageView mShadow;
    ImageView mHelper;
    //RelativeLayout.LayoutParams lBeginParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRoot = (RelativeLayout)findViewById(R.id.relativeLayout);
        mImageView = (ImageView) findViewById(R.id.imageViewUnlock);
        mBar = (ImageView) findViewById(R.id.barUnlock);
        mTime = (TextView) findViewById(R.id.textViewTime);
        mHelper = (ImageView) findViewById(R.id.imageViewUnlockHelper);
        mShadow = (ImageView) findViewById(R.id.imageViewUnlockShadow);
        mImageView.setOnTouchListener(this);
        //lBeginParams = (RelativeLayout.LayoutParams) mImageView.getLayoutParams();
        mTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityDesktop.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int x = (int) event.getRawX();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) mImageView.getLayoutParams();
                mXDelta = x - lParams.leftMargin;
                //mImageView.setLayoutParams(lBeginParams);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mImageView.getLayoutParams();
                RelativeLayout.LayoutParams layoutParamsHelper = (RelativeLayout.LayoutParams) mHelper.getLayoutParams();
                //if(x - mXDelta > lBeginParams.leftMargin)
                //layoutParams.leftMargin = x - mXDelta;
                //else
                    //layoutParams.leftMargin = lBeginParams.leftMargin;
                //layoutParams.rightMargin = -250;
                //mImageView.setLayoutParams(layoutParams);
                int [] location1 = new int[2];
                mImageView.getLocationOnScreen(location1);

                int [] location2 = new int[2];
                mShadow.getLocationOnScreen(location2);

                int [] location3 = new int[2];
                mHelper.getLocationOnScreen(location3);

                if(location1[0] < location3[0]){
                    layoutParams = layoutParamsHelper;
                    mImageView.setLayoutParams(layoutParams);
                }else if(location1[0] < location2[0]){
                    layoutParams.leftMargin = x - mXDelta;
                    mImageView.setLayoutParams(layoutParams);
                }else{
                    startActivity(new Intent(MainActivity.this, ActivityDesktop.class));

                }


                break;
        }
        mRoot.invalidate();
        return true;
    }
}
