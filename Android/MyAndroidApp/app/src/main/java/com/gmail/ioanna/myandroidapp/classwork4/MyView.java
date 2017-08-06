package com.gmail.ioanna.myandroidapp.classwork4;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.gmail.ioanna.myandroidapp.R;


public class MyView extends View {

    private Paint myPaint = new Paint();
    private RectF arcRectF = new RectF();

    int cx;
    int cy;

    public MyView(Context context) {
        super(context);
        initialize();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    private void initialize(){
        myPaint.setAntiAlias(true);
        int color = ContextCompat.getColor(getContext(), R.color.dz2_green);
        myPaint.setColor(color);
        myPaint.setStyle(Paint.Style.FILL);
        Resources r = getResources();
        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                2, r.getDisplayMetrics());
        myPaint.setStrokeWidth(strokeWidthInPx);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = Math.min(getWidth(),getHeight())/4;
        canvas.drawCircle(cx,cy, radius, myPaint);

       /* int startX = 0;
        int startY = 0;
        int stopX = getWidth();
        int stopY = getHeight();
        canvas.drawLine(startX,startY,stopX,stopY,myPaint);

        arcRectF.left = 0;
        arcRectF.top = 0;
        arcRectF.right = getWidth();
        arcRectF.bottom = getHeight();
        canvas.drawArc(arcRectF, 0,90, true, myPaint);

        canvas.drawRect(50,50,100,100,myPaint);*/

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_MOVE){
            cx = (int)event.getX();
            cy = (int)event.getY();
            invalidate();
        }else if(event.getAction() == MotionEvent.ACTION_DOWN){

        }else if(event.getAction() == MotionEvent.ACTION_UP){

        }
        return true;
    }
}
