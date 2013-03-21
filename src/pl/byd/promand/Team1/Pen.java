package pl.byd.promand.Team1;

import android.graphics.Paint;

public class Pen extends Shape {

    int x;
    int y;
    int radius, color;
    Paint paint =new Paint();

    public Pen(int xx, int yy, int r, Paint pColor)
    {
        x=xx;
        y=yy;
        radius=r;
        paint=pColor;
        tool = 2;
    }

}
