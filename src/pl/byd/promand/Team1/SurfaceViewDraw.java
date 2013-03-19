package pl.byd.promand.Team1;


import android.content.Context;
import android.graphics.*;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.promand.Team1.R;


public class SurfaceViewDraw extends SurfaceView {


    SurfaceHolder surfHolder;
 //   Bitmap photoBitmap;
   int counter = 0;

    Bitmap mergedBitmap =null; //this bitmap here contains the whole of the drawing (background+foreground) to be saved.

   Bitmap bitmap = null; //bitmap onto which we draw our stuff
   // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blank);

  //  Canvas canvas - Main canvas. Will be linked to a .bmp file

    int mBackgroundColor = Color.WHITE; //default background color
    Paint mDefaultPaint = new Paint();


    Paint mDrawPaint = new Paint(); //used for painting example foreground stuff... We draw line segments.
    Point drawPoints = new Point(); //used to store last location on our PaintView that was finger-touched

      // constructor - empty surface
     public SurfaceViewDraw(Context context, int width, int height){
        super(context);
        surfHolder = getHolder();
     }

    /*
    public void drawOnSurface(float x, float y, float r, Paint mPaint)
    {

          //  if(!surfHolder.getSurface().isValid())

       Canvas canvas = surfHolder.lockCanvas();
       if (photoBitmap==null)
        {
            {
                if(x!=0 && y!=0)
                    canvas.drawCircle(x,y,r*5,mPaint);

            }

        }


       surfHolder.unlockCanvasAndPost(canvas);
     }       */



    //Called by user of PaintView in order to start a painting "stroke" (finger touching touch-screen): stores the
    //location of the finger when it first touched the screen
    public void startDraw(int x, int y, int radius, int color, int backColor){
        mDrawPaint.setColor(color);
       // mDrawPaint.setStyle(Paint.Style.FILL);
       // mDrawPaint.setStrokeWidth(radius);
        drawPoints.x = x;
        drawPoints.y = y;
        if (counter==0)
          {changeColor(backColor);
             ++counter;}
    }

    //Called by user of PaintView when finger touching touch-screen is moving (must be called after a startDraw,
    //as the latter initializes a couple of necessary things)
    public void continueDraw(int x, int y, int radius){

        Canvas canvas = surfHolder.lockCanvas();
        //canvas.drawLine(drawPoints.x, drawPoints.y, x, y, mDrawPaint);
        //canvas.drawCircle(x,y,radius*5,mDrawPaint);
        if(ModelRoot.getRoot().getTool()=="pen"){
               canvas.drawCircle(x, y, radius * 3, mDrawPaint); ///TODO adding colour maybe
        }
        if(ModelRoot.getRoot().getTool()=="text"){
            Paint paint = new Paint();
            paint.setColor(Color.WHITE); //here would be Color.getColor()
            paint.setStyle(Paint.Style.FILL);
            canvas.drawPaint(paint);

            paint.setColor(Color.BLACK);
            paint.setTextSize(20); //getWidth() sth
            canvas.drawText("Some Text", x, x, paint);
        }
        if(ModelRoot.getRoot().getTool()=="rectangle"){  //similar to drawing a line
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            //paint.setStrokeWidth(3); // get from Width
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(x, y, x+30, y+50, paint);
           // paint.setStrokeWidth(0);
           // paint.setColor(Color.CYAN);
           // canvas.drawRect(33, 60, 77, 77, paint );
           // paint.setColor(Color.YELLOW);
           // canvas.drawRect(33, 33, 77, 60, paint );
        }

        surfHolder.unlockCanvasAndPost(canvas);
        drawPoints.x = x;
        drawPoints.y = y;
     //   postInvalidate(); //refresh view: this will indirectly invoke onDraw soon afterwards
    }

    //Merge the foreground Canvas-Bitmap with a solid background color, then stores this in the 2nd Canvas-Bitmap pair.
    private void mergeLayers(){
        Canvas mergedCanvas = surfHolder.lockCanvas();
        mergedCanvas.drawRGB(255,250,240);
        //mergedCanvas.drawColor(mBackgroundColor);
        mergedCanvas.drawBitmap(bitmap, 0, 0, mDefaultPaint);
        surfHolder.unlockCanvasAndPost(mergedCanvas);
    }

    //Change background color
    public void changeColor(int newColor){
      //  mBackgroundColor = Color.WHITE;
        Canvas mergedCanvas = surfHolder.lockCanvas();
        mergedCanvas.drawRGB(255,250,240);
        surfHolder.unlockCanvasAndPost(mergedCanvas);
    //    postInvalidate(); //refresh view: this will indirectly invoke onDraw soon afterwards
   }

    /*
       //   Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blank);
     //   canvas.drawBitmap(myBitmap, 0, 0, null);
             */

  /*  @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
     //   mergeLayers();
        canvas = surfHolder.lockCanvas();
        canvas.drawBitmap(bitmap, 0, 0, mDefaultPaint);
        surfHolder.unlockCanvasAndPost(canvas);
    }              */
}

