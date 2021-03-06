package com.krp.android.demoandroidshape;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView button = (ImageView) findViewById(R.id.iv_round_rec);
        InputStream resource = getResources().openRawResource(R.raw.map);
        Bitmap bitmap = BitmapFactory.decodeStream(resource);
        button.setBackground(new MyRoundCornerDrawable(bitmap));


        /*button = (ImageView) findViewById(R.id.iv_cust);
        resource = getResources().openRawResource(R.raw.map);
        bitmap = BitmapFactory.decodeStream(resource);
        button.setBackground(new MyOneSideInDepthRectangleDrawable(bitmap));*/


        button = (ImageView) findViewById(R.id.iv_inward_bent_rec);
        button.setBackground(new MyOneSideInDepthRectangleDrawable(Color.GRAY));


        TextView v = (TextView) findViewById(R.id.iv_cust);
        resource = getResources().openRawResource(R.raw.map);
        bitmap = BitmapFactory.decodeStream(resource);
        v.setBackground(new MyCustomDrawable(android.R.color.darker_gray));

        v = (TextView) findViewById(R.id.iv_cust1);
        resource = getResources().openRawResource(R.raw.map);
        bitmap = BitmapFactory.decodeStream(resource);
        v.setBackground(new BezierCurveDrawable(this, android.R.color.holo_green_dark));

    }
}
