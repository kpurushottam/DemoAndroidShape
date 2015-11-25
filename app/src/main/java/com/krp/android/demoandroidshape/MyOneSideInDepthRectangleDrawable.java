package com.krp.android.demoandroidshape;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by purushottam.kumar on 11/25/2015.
 */
public class MyOneSideInDepthRectangleDrawable extends Drawable {
    private Paint paint;

    public MyOneSideInDepthRectangleDrawable(Bitmap bitmap) {
        BitmapShader shader;
        shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
    }

    public MyOneSideInDepthRectangleDrawable(int color) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
    }

    @Override
    public void draw(Canvas canvas) {
        int height = getBounds().height();
        int width = getBounds().width();
        RectF rect = new RectF(0.0f, 0.0f, width, height);
        Path p = new Path();
        p.moveTo(0.0f, 0.0f);
        p.lineTo(0.0f, height);
        p.lineTo(width, height);
        p.lineTo(width - height/4f, height/2f);
        p.lineTo(width, 0.0f);
        p.lineTo(0.0f, 0.0f);
        canvas.drawPath(p, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
