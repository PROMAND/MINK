package pl.byd.promand.Team1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.*;
import android.widget.*;
import com.promand.Team1.R;

import java.util.ArrayList;

public class MyActivity extends Activity implements View.OnTouchListener{

   SurfaceViewDraw view;
    Context context = this;
    LinearLayout surfaceViewLayout;
    float x, y;

    ArrayList<Path> pointsToDraw = new ArrayList<Path>();
    Paint mPaint;
    Path path;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button tools = (Button) findViewById(R.id.button1);
        Button width = (Button) findViewById(R.id.button2);
        width.setText(width.getText() + " " + ModelRoot.getRoot().getWidth());
        Button colors = (Button) findViewById(R.id.button3);
        colors.setBackgroundColor(Color.parseColor(ModelRoot.getRoot().getColor()));
        Button settings = (Button) findViewById(R.id.button4);

        surfaceViewLayout = (LinearLayout)findViewById(R.id.SurfaceViewLayout);
        ImageButton AddNew = (ImageButton) findViewById(R.id.upbutton2);
        ImageButton SaveButton = (ImageButton) findViewById(R.id.upbutton3);
        x=0;
        y=0;


        //drawing surface class
        view = new SurfaceViewDraw(context);

        surfaceViewLayout.addView(view);
        view.setOnTouchListener(this);

        mPaint = new Paint();
      //  mPaint.setDither(true);
        mPaint.setColor(Color.GREEN);
      /*  mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(30);      */




        tools.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, Tools.class);
                startActivity(i);
            }
        });

        width.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, WidthMain.class);
                startActivityForResult(i, 2);
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, ColorChange.class);
                startActivityForResult(i, 1);
            }
        });


        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, SettingsActivity.class);
                startActivityForResult(i, 3);

            }
        });





        AddNew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.new_image);
                dialog.setTitle("An image is opened");

                Button no = (Button) dialog.findViewById(R.id.bNo);
                Button yes = (Button) dialog.findViewById(R.id.bYes);

                no.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                yes.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        //*********************************
                        //New image
                        //**********************************

                        dialog.dismiss();

                    }

                });
                dialog.show();
            }
        });

        SaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.save);
                dialog.setTitle("Choose the folder");

                final ListView folderSave = (ListView) dialog.findViewById(R.id.lFolderSave);
                Button save = (Button) dialog.findViewById(R.id.bSave);
                Button exit = (Button) dialog.findViewById(R.id.bCancel);

                final Folders folder = new Folders();
                folder.setCurrentPath(Environment.getExternalStorageDirectory());

                final ArrayList<String> values = new ArrayList<String>(folder.getListOfFolders());
                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (context, R.layout.adapter, R.id.tFolderName, values);

                folderSave.setAdapter(adapter);

                folderSave.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                        String s = values.get(position);

                        Toast.makeText(MyActivity.this, "Folder: "+s, Toast.LENGTH_SHORT).show();

                    }
                });



                exit.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        Toast.makeText(context, "File is saved", 3000).show();
                        dialog.dismiss();
                    }

                });
                dialog.show();
            }
        });


    }

  @Override
    protected void onResume() {
        super.onResume();
        view.resume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        view.pause();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1) {
            SurfaceView view = (SurfaceView) findViewById(R.id.surfaceView1);
            view.setBackgroundColor(Color.parseColor(ModelRoot.getRoot().getColor()));
            Button colorB = (Button) findViewById(R.id.button3);
            colorB.setBackgroundColor(Color.parseColor(ModelRoot.getRoot().getColor()));
        }

        if (resultCode == 2) {
            Button widthB = (Button) findViewById(R.id.button2);
            widthB.setText("Width: " + ModelRoot.getRoot().getWidth());
        }

        if (resultCode == 3) {
            Bitmap tempBitmap = ModelRoot.getRoot().getBitmap();
          // SurfaceView photoSurface = new SurfaceViewDraw(context, tempBitmap);
         //  surfaceViewLayout.addView(photoSurface);

        }


    }


   @Override
    public boolean onTouch(View view, MotionEvent me) {

       x = me.getX();
       y = me.getY();
       return true;
    }


    public class SurfaceViewDraw extends SurfaceView implements Runnable {


        SurfaceHolder surfHolder;
        Thread drawingThread;
        boolean isRunning = false;
        Bitmap photoBitmap;


        // constructor no. 1 - empty surface
        public SurfaceViewDraw(Context context){
            super(context);
            surfHolder = getHolder();
            //setBackgroundColor(Color.rgb(250,255,240));
        }

        // constructor no. 2 - surface with photo
        public SurfaceViewDraw(Context context, Bitmap bitmap){
            super(context);
            surfHolder = getHolder();
            photoBitmap = Bitmap.createBitmap(bitmap) ;
            //setBackgroundDrawable(new BitmapDrawable(photoBitmap));

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
                     if (x!=0 && y!=0)
                       canvas.drawCircle(x, y, 50, mPaint);

                }

                //else canvas.setBitmap(photoBitmap);


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

    }




}
