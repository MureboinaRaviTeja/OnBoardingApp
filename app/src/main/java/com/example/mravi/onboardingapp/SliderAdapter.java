package com.example.mravi.onboardingapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by mravi on 08-01-2018.
 */

public class SliderAdapter extends PagerAdapter {

    Context contex;
    //context is used for to add context whrer ever it is required

    LayoutInflater layoutInflater;


    public SliderAdapter(Context context){
        this.contex=context;

    }

    //store the vlaues for the slider ;

    public int[] slider_images={

      //it stores the images that are there in the  slider ;

            R.drawable.eat,
    R.drawable.eat2,
            R.drawable.eat3

    };


    public String[]  slide_headings={

            "EAT",
            "SLEEP",
            "CODE"

    };

    public String[] slide_desc={

      "Hello how are you this is Ravi,This is page one,WHich shows you to eat  ",
            "Hello how are you this is Ravi '\n' This is page one  '\n' WHich shows you to code",
            "Hello how are you this is Ravi '\n' This is page one '\n' WHich shows you to sleep"

    };




    @Override
    public int getCount() {
        return slide_headings.length;
    //gives the lenght of the total headings that we have

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return  view==(RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //used to add slide effect

        layoutInflater =(LayoutInflater)contex.getSystemService(contex.LAYOUT_INFLATER_SERVICE);

        View view =layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView=(ImageView) view.findViewById(R.id.imageView);
        TextView slideHeading=(TextView) view.findViewById(R.id.textView);
        TextView slideDescription=(TextView) view.findViewById(R.id.textView2);

        slideImageView.setImageResource(slider_images[position]);

        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;

    };

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
        //romove the slide after completed
        //insted of creatintg multiple slides it  will stop
    }
}
