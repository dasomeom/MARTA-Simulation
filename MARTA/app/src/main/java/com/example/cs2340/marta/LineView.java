package com.example.cs2340.marta;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class LineView extends View {
    public Paint paint = new Paint();
    private float ax, ay, bx, by;
    private int aColor;
    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(aColor);
        paint.setStrokeWidth(7f);
        canvas.drawLine(ax, ay, bx, by, paint);
        super.onDraw(canvas);

    }

    public float getAx() {
        return ax;
    }

    public void setAx(float ax) {
        this.ax = ax;
    }

    public float getAy() {
        return ay;
    }

    public void setAy(float ay) {
        this.ay = ay;
    }

    public float getBx() {
        return bx;
    }

    public void setBx(float bx) {
        this.bx = bx;
    }

    public float getBy() {
        return by;
    }

    public void setBy(float by) {
        this.by = by;
    }

    public int getaColor() {
        return aColor;
    }

    public void setaColor(int aColor) {
        this.aColor = aColor;
    }

    public void draw() {
        invalidate();
        requestLayout();
    }
}
