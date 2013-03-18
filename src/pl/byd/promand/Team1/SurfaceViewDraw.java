package pl.byd.promand.Team1;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.promand.Team1.R;

public class SurfaceViewDraw extends SurfaceView implements Runnable {


    SurfaceHolder surfHolder;
    Thread drawingThread;
    boolean isRunning = true;


    public SurfaceViewDraw(Context context){
        super(context);
        surfHolder = getHolder();
        drawingThread = new Thread(this);
       // drawingThread.start();

    }

             public void run(){
             while(isRunning){
                 if(!surfHolder.getSurface().isValid())
                     continue;

                 Canvas canvas = surfHolder.lockCanvas();
                 canvas.drawRGB(02,02,150);
                 surfHolder.unlockCanvasAndPost(canvas);
             }


     }


}
