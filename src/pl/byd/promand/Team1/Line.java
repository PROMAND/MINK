package pl.byd.promand.Team1;


import android.graphics.Paint;

public class Line extends Shape {

    float x1,y1,x2,y2;
    int lineWidth, color;
    Paint paint =new Paint();

     public void startLine(float xx1, float yy1, int width,Paint lineColor)
     {
        x1=xx1;
        y1=yy1;
        lineWidth=width;
        paint=lineColor;
        tool=3;
     }

     public void endLine(float xx2, float yy2)
     {
        x2=xx2;
        y2=yy2;

     }


}
