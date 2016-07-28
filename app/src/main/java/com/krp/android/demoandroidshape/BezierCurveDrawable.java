package com.krp.android.demoandroidshape;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by purushottam.kumar on 11/24/2015.
 */
public class BezierCurveDrawable extends Drawable {
    private Paint paint;

    public BezierCurveDrawable(Bitmap bitmap) {
        BitmapShader shader;
        shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
    }

    public BezierCurveDrawable(int color) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
    }

    public BezierCurveDrawable(Context context, int resId) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(ContextCompat.getColor(context, resId));
    }

    @Override
    public void draw(Canvas canvas) {
        int height = getBounds().height();
        int width = getBounds().width();
        RectF rect = new RectF(0.0f, 0.0f, width, height-10f);
        canvas.drawRoundRect(rect, 30, 30, paint);

        Path path = new Path();
        path.moveTo(width/2f - 10f, height-10f);
        path.lineTo(width/2f, height);
        path.lineTo(width/2f + 10f, height-10f);
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
