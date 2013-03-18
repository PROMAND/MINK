/*package pl.byd.promand.Team1;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class SurfaceViewDraw extends SurfaceView implements Runnable {


    SurfaceHolder surfHolder;
    Thread drawingThread;
    boolean isRunning = false;
    Bitmap photoBitmap;

      // constructor no. 1 - empty surface
    public SurfaceViewDraw(Context context){
        super(context);
        surfHolder = getHolder();

    }

    // constructor no. 2 - surface with photo
    public SurfaceViewDraw(Context context, Bitmap bitmap){
        super(context);
        surfHolder = getHolder();
        photoBitmap = Bitmap.createBitmap(bitmap) ;

    }


    public void run()
    {
        while(isRunning)
        {
            if(!surfHolder.getSurface().isValid())
                continue;

            Canvas canvas = surfHolder.lockCanvas();
            if (photoBitmap==null)
            {
                if(x!=0 && y!=0)
                {
                    canvas.drawRGB(255,250,240);
                    canvas.drawCircle(x,y,60,new Paint());
                }
            }

            else canvas.setBitmap(photoBitmap);


            surfHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void pause()
    {
        isRunning = false;
        while(true)
        {
            try {
                drawingThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        drawingThread = null;
    }

    public void resume()
    {
        isRunning = true;
        drawingThread = new Thread(this);
        drawingThread.start();

    }


    @Override
    public void draw(Canvas canvas) {

        super.draw(canvas);
        synchronized(pointsToDraw)
        {
            for (Path path : pointsToDraw) {
                canvas.drawPath(path, mPaint);
            }
        }
    }





}
         */
