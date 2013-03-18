package pl.byd.promand.Team1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Environment;
import android.view.*;
import android.widget.*;
import android.widget.*;
import com.promand.Team1.R;

import java.util.ArrayList;

import java.util.ArrayList;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
      SurfaceView view;
      LinearLayout surfaceViewLayout;//
      Context context = this;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Dialog start = new Dialog(context);
        start.setTitle("Let's start");
        start.setContentView(R.layout.start_dialog);
        start.show();

        ImageButton newFile = (ImageButton) start.findViewById(R.id.newButton);
        ImageButton openFile = (ImageButton) start.findViewById(R.id.loadButton);
        ImageButton takeAPhoto = (ImageButton) start.findViewById(R.id.takeAPhotoButton);

        newFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.dismiss();
            }
        });

        openFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.load);
                dialog.setTitle("Choose the folder");

                final ListView folderLoad = (ListView) dialog.findViewById(R.id.lFolderLoad);
                folderLoad.setClickable(true);

                Button load = (Button) dialog.findViewById(R.id.bLoad);
                Button exit = (Button) dialog.findViewById(R.id.bExit1);


                final Folders folder = new Folders();
                folder.setCurrentPath(Environment.getExternalStorageDirectory());

                final ArrayList<String> values = new ArrayList<String>(folder.getListOfFolders());

                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (context, R.layout.adapter, R.id.tFolderName, values);

                folderLoad.setAdapter(adapter);

                folderLoad.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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

                load.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        //*********************************
                        //loading image
                        //**********************************
                    }

                });

                dialog.show();
            }
        });

        takeAPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 0);
            }
        });

        Button tools = (Button) findViewById(R.id.button1);
        Button width = (Button) findViewById(R.id.button2);
        width.setText(width.getText() + " " + ModelRoot.getRoot().getWidth());
        Button colors = (Button) findViewById(R.id.button3);
        colors.setBackgroundColor(Color.parseColor(ModelRoot.getRoot().getColor()));
        Button settings = (Button) findViewById(R.id.button4);
        view = (SurfaceView) findViewById(R.id.surfaceView1);
        surfaceViewLayout = (LinearLayout)findViewById(R.id.SurfaceViewLayout);
        ImageButton AddNew = (ImageButton) findViewById(R.id.upbutton2);
        ImageButton SaveButton = (ImageButton) findViewById(R.id.upbutton3);
        ImageButton ShareButton = (ImageButton) findViewById(R.id.upbutton4);

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
                startActivity(i);
            }
        });

       //drawing class
       surfaceViewLayout.addView(new SurfaceViewDraw(this));


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

        ShareButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, ShareActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1) {
            Button colorB = (Button) findViewById(R.id.button3);
            colorB.setBackgroundColor(Color.parseColor(ModelRoot.getRoot().getColor()));
        }

        if (resultCode == 2) {
            Button widthB = (Button) findViewById(R.id.button2);
            widthB.setText("Width: " + ModelRoot.getRoot().getWidth());
        }
    }
}
