package com.gmail.ioanna.myandroidapp.dz4;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.gmail.ioanna.myandroidapp.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MyView extends View {
    Date date = new Date();
    Calendar calendar = new GregorianCalendar();

    private Paint myPaint = new Paint();
    int seconds;
    int minutes;
    int hours;

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
        int color = ContextCompat.getColor(getContext(), R.color.black);
        myPaint.setColor(color);
        myPaint.setStyle(Paint.Style.STROKE);
        Resources r = getResources();
        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                2, r.getDisplayMetrics());
        myPaint.setStrokeWidth(strokeWidthInPx);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int radius = Math.min(getWidth(),getHeight())/3;
        canvas.drawCircle(getWidth()/2,getHeight() - getHeight()/3, radius, myPaint);
        myPaint.setTextSize(24);
        canvas.drawText("12", getWidth()/2 - 12, 60+ + getHeight() - getHeight()/3 - radius, myPaint);
        canvas.drawText("6", getWidth()/2 - 6, getHeight() - getHeight()/3 + radius - 40, myPaint);
        canvas.drawText("3",getWidth()/2 + radius - 50, getHeight() - getHeight()/3 + 12, myPaint);
        canvas.drawText("9", getWidth()/2 - radius + 40, getHeight() - getHeight()/3 + 12, myPaint);

        for(int i = 0; i < 60; i++) {
            if(i%15 == 0 || i == 0) {
                myPaint.setStrokeWidth(5);
                myPaint.setColor(ContextCompat.getColor(getContext(),R.color.dz2_red));
                canvas.drawLine(getWidth()/2, getHeight() - getHeight()/3 - radius, getWidth()/2, 30 + getHeight() - getHeight()/3 - radius, myPaint);
            } else if(i%5 == 0){
                myPaint.setColor(ContextCompat.getColor(getContext(),R.color.dz2_blue));
                myPaint.setStrokeWidth(3.5f);
                canvas.drawLine(getWidth()/2, getHeight() - getHeight()/3 - radius, getWidth()/2, 20 + getHeight() - getHeight()/3 - radius, myPaint);
            }
            else{
                myPaint.setStrokeWidth(2);
                myPaint.setColor(ContextCompat.getColor(getContext(),R.color.black));
                canvas.drawLine(getWidth()/2,getHeight() - getHeight()/3 - radius, getWidth()/2, 10 + getHeight() - getHeight()/3 - radius, myPaint);
            }
            canvas.rotate(6,getWidth()/2,getHeight() - getHeight()/3);
        }



        seconds = calendar.getTime().getSeconds();
        minutes = calendar.getTime().getMinutes();
        hours = calendar.getTime().getHours();
        Log.e("time",calendar.getTime().toString());
        for(int i = 0;i < 60; i++) {
            if(i == seconds) {
                myPaint.setStrokeWidth(1);
                canvas.drawLine(getWidth()/2, getHeight() - getHeight()/3, getWidth()/2, 30 - radius + getHeight() - getHeight()/3, myPaint);
            }
            if(i == minutes){
                myPaint.setColor(ContextCompat.getColor(getContext(),R.color.dz2_blue));
                myPaint.setStrokeWidth(2.5f);
                canvas.drawLine(getWidth()/2,getHeight() - getHeight()/3, getWidth()/2, 50 - radius + getHeight() - getHeight()/3, myPaint);
            }
            canvas.rotate(6,getWidth()/2,getHeight() - getHeight()/3);
        }
        for(int i = 0; i <= hours; i++){
            if(i == hours){
                myPaint.setColor(ContextCompat.getColor(getContext(),R.color.dz2_red));
                myPaint.setStrokeWidth(3);
                canvas.drawLine(getWidth()/2,getHeight() - getHeight()/3, getWidth()/2, 70 - radius + getHeight() - getHeight()/3, myPaint);
            }
            canvas.rotate(30,getWidth()/2,getHeight() - getHeight()/3);
        }

    }
}
