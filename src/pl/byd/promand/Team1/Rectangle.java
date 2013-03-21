package pl.byd.promand.Team1;


import android.graphics.Paint;

public class Rectangle extends Shape{

    int lineWidth, color;
    float x1,y1,x2,y2;
    Paint paint =new Paint();

    public void startRect(float xx1, float yy1, int width,Paint recColor)
    {
        x1=xx1;
        y1=yy1;
        lineWidth=width;
        paint=recColor;
        tool=5;
    }



    public void endRect(float xx2, float yy2)
    {
        x2=xx2;
        y2=yy2;

    }



}
