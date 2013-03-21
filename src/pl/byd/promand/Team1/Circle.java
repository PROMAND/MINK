package pl.byd.promand.Team1;


import android.graphics.Paint;

public class Circle extends Shape {

    float x1,y1,x2,y2, radius;
    int lineWidth, color;

    Paint paint =new Paint();


   // int tool = 4;

    public void startCircle(float xx, float yy, int brush, Paint circleColor)
    {
        x1=xx;
        y1=yy;
        lineWidth=brush;
        paint=circleColor;
        tool=4;
    }


    public float endCircle(float xx, float yy)
    {
        x2=xx;
        y2=yy;

        radius= (float) Math.hypot(Math.abs(x2-x1),Math.abs(y2-y1)) ;
        radius=radius/2;
        return radius;
    }

}
