package com.example.praktikum_sensor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BubbleView extends View {

    private Paint paintBubble;


    private float offsetX;
    private  float offsetY;

    public BubbleView(Context context, AttributeSet attrs){
        super(context, attrs);
        Init();
    }



    private  void Init(){
        paintBubble = new Paint();

        paintBubble.setStyle(Paint.Style.FILL);
        paintBubble.setColor(Color.parseColor("#A5D6A7"));

    }

    public void SetOffset(float newOffsetX, float newOffsetY){
        this.offsetX = newOffsetX;
        this.offsetY = newOffsetY;

        invalidate();
    }

    @Override
    protected  void  onDraw(Canvas canvas){

        super.onDraw(canvas);

        float height = getHeight();
        float width = getWidth();

        float cx = width / 2;
        float cy = height / 2;

        float smallDimension = Math.min(cx, cy);

        float R = smallDimension / 2f * 0.90f;

        float radius = R * 0.2f;

        float bubbleX = cx + offsetX * (R - radius);
        float bubbleY = cy + offsetY * (R - radius);

        canvas.drawCircle(bubbleX, bubbleY, radius, paintBubble);
    }
}
