package com.example.mravi.onboardingapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private SliderAdapter sliderAdapter;

    private TextView[] mDots;



    private Button mNextBtn;
    private Button mBackBtn;
private int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dots_layout);
        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);


        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

 /*
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });

/*
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });*/
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        mDotLayout.removeAllViews();//if not it will create multiple number of dots

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
mDots[i].setTextSize(60);

            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
mDotLayout.addView(mDots[i]);
        }
if(mDots.length>0){
    mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));

}

    }

    //to view in page we are in
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            mCurrentPage=position;
            if(position==0){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
            mBackBtn.setVisibility(View.INVISIBLE);

                mBackBtn.setText("");

            }

          if(position==3){

              Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();

            }


        }


        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
