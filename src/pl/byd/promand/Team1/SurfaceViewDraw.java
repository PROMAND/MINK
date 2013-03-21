package pl.byd.promand.Team1;


import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SurfaceViewDraw extends View {
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    Point3D pnt;
    Line line;
    Rectangle rect;
    Circle circ;
    Pen pntPen;
    Eraser erase;
    Bitmap tempBitmap=null;

    private Paint paint = new Paint();


    public ViewGroup.LayoutParams params;

    public SurfaceViewDraw(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SurfaceViewDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SurfaceViewDraw(Context context) {
        super(context);


        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        setDrawingCacheEnabled(true);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        tempBitmap=ModelRoot.getRoot().getBitmap();
        int  tempBackground = Color.parseColor(ModelRoot.getRoot().getBackColor()) ;


        if(tempBitmap==null)
        {
            canvas.drawColor(tempBackground);                              //background color
        }
        else
        {
            canvas.drawBitmap(tempBitmap,0,0,null);               // background bitmap
        }


        for (Shape value: shapes)
        {

            int tools = value.tool;
            switch(tools)
            {
                case 4:        //circle
                {

                    Circle cir = (Circle)value;
                    cir.paint.setStyle(Paint.Style.STROKE);
                    canvas.drawCircle(cir.x1,cir.y1,cir.radius,cir.paint);
                    break;
                }

                case 5:        //rectangle
                {

                    Rectangle rec  = (Rectangle)value;
                    rec.paint.setStyle(Paint.Style.STROKE);
                    canvas.drawRect(rec.x1,rec.y1,rec.x2,rec.y2,rec.paint);
                    break;
                }

                case 3:        //line
                {

                    Line ln = (Line)value;
                    ln.paint.setStrokeWidth(ln.lineWidth);
                    canvas.drawLine(ln.x1,ln.y1,ln.x2,ln.y2,ln.paint);
                    break;
                }

                case 1:        // brush
                {

                    Point3D point = (Point3D)value;
                    point.paint.setStyle(Paint.Style.FILL);
                    canvas.drawCircle(point.x,point.y,point.radius,point.paint);
                    break;
                }


                case 2:    // pen
                {

                    Pen point = (Pen)value;
                    point.paint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(point.x, point.y,point.x+5,point.y+5,point.paint);
                    break;
                }

                case 6:    // eraser
                {

                    Eraser erase = (Eraser)value;
                    erase.paint.setStyle(Paint.Style.FILL);
                    erase.paint.setColor(tempBackground);

                    erase.paint.setStrokeJoin(Paint.Join.BEVEL);
                    canvas.drawCircle(erase.x, erase.y,  erase.radius ,erase.paint);
                    break;
                }

            }
        }

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

       int brush = Integer.parseInt(ModelRoot.getRoot().getWidth());
       int tempColor = Color.parseColor(ModelRoot.getRoot().getColor());
       int tempBackground = Color.parseColor(ModelRoot.getRoot().getBackColor()) ;

        Paint tempPaint = new Paint();
       Paint tempBackPaint = new Paint();


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {


                tempPaint.setStrokeWidth(brush);
                tempPaint.setColor(tempColor);
                tempBackPaint.setColor(tempBackground);

                circ = new Circle();
                circ.startCircle(x,y,brush*3, tempPaint);

                rect = new Rectangle();
                rect.startRect(x,y,brush*3, tempPaint);

                line = new Line();
                line.startLine(x,y,brush*3,  tempPaint);

                pnt = new Point3D((int)x,(int)y,brush*3, tempPaint);

                pntPen = new Pen((int)x,(int)y,2, tempPaint);

                erase = new Eraser((int)x,(int)y,brush*3, tempBackPaint);

                return true;
            }
            case MotionEvent.ACTION_MOVE: {

                switch(ModelRoot.getRoot().getTool())
                {

                    case 1:       //brush
                    {
                        tempPaint.setStrokeWidth(brush);
                        tempPaint.setColor(tempColor);
                        pnt = new Point3D((int)x,(int)y, brush*3, tempPaint);
                        shapes.add(pnt);

                        break;
                    }

                    case 4:         // circle
                    {


                        circ.endCircle(x,y);

                        shapes.add(circ);

                        break;
                    }

                    case 5:           // rectangle
                    {
                        rect.endRect(x,y);

                        shapes.add(rect);

                        break;
                    }

                    case 3:       // line
                    {
                        line.endLine(x,y);

                        shapes.add(line);

                        break;
                    }

                    case 2:        // pen
                    {
                        tempPaint.setStrokeWidth(brush);
                        tempPaint.setColor(tempColor);
                        pntPen = new Pen((int)x,(int)y,2,tempPaint);
                        shapes.add(pntPen);

                        break;
                    }

                    case 6:        // eraser
                    {
                        tempPaint.setStrokeWidth(brush);
                        tempPaint.setColor(tempBackground);
                        erase = new Eraser((int)x,(int)y,brush*3,tempBackPaint);
                        shapes.add(erase);

                        break;
                    }


                }


                break;
            }
            case MotionEvent.ACTION_UP: {

                switch(ModelRoot.getRoot().getTool())
                {
                    case 1:    // brush
                    {
                        tempPaint.setStrokeWidth(brush);
                        tempPaint.setColor(tempColor);

                        pnt = new Point3D((int)x,(int)y, brush*3, tempPaint);
                        shapes.add(pnt);

                        break;
                    }

                    case 4:     // circle
                    {
                        circ.endCircle(x,y);

                        shapes.add(circ);

                        break;
                    }

                    case 5:    // rectangle
                    {
                        rect.endRect(x,y);

                        shapes.add(rect);

                        break;
                    }

                    case 3:     // line
                    {
                        line.endLine(x,y);

                        shapes.add(line);

                        break;
                    }


                    case 2:   //pen
                    {

                        tempPaint.setStrokeWidth(brush);
                        tempPaint.setColor(tempColor);
                        pntPen = new Pen((int)x,(int)y,2, tempPaint);
                        shapes.add(pntPen);

                        break;
                    }

                    case 6:        // eraser
                    {
                        tempPaint.setStrokeWidth(brush);
                        tempPaint.setColor(tempBackground);
                        erase = new Eraser((int)x,(int)y,brush*3,tempBackPaint);
                        shapes.add(erase);
                        break;
                    }

                }

                break;
            }
            default:
            {
                return false;
            }
        }

        postInvalidate();
        return true;
    }

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
    }

}

