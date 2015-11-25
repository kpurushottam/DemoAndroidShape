package com.krp.android.demoandroidshape;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by purushottam.kumar on 11/24/2015.
 */
public class MyCustomDrawable extends Drawable {
    private Paint paint;

    public MyCustomDrawable(Bitmap bitmap) {
        BitmapShader shader;
        shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
    }

    public MyCustomDrawable(int color) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
    }

    @Override
    public void draw(Canvas canvas) {
        int height = getBounds().height();
        int width = getBounds().width();
        RectF rect = new RectF(0.0f, 0.0f, width - 30f, height);
        canvas.drawRoundRect(rect, 30, 30, paint);

        Path path = new Path();
        path.moveTo(width / 2f, height);
        path.lineTo(width, height);
        path.lineTo(width - 30f, height - 10f);
        path.lineTo(width - 30f, height/2f);
        canvas.drawPath(path, paint);
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
