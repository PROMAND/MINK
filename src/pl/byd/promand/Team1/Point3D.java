package pl.byd.promand.Team1;


import android.graphics.Paint;

public class Point3D extends Shape {

    int x;
    int y;
    int radius, color;
    Paint paint =new Paint();

    public Point3D(int xx, int yy, int r, Paint pColor)
    {
        x=xx;
        y=yy;
        radius=r;
        paint=pColor;
        tool = 1;
    }

}
