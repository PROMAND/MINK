package pl.byd.promand.Team1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceView;
import android.view.View;
import android.widget.*;
import com.promand.Team1.R;

import java.io.File;
import java.util.ArrayList;


public class SettingsActivity extends Activity {

    public static Bitmap bitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        Button newImage = (Button) findViewById(R.id.bNewImage);
        Button saveImage = (Button) findViewById(R.id.bSaveImage);
        Button loadImage = (Button) findViewById(R.id.bLoadImage);
        Button cameraShot = (Button) findViewById(R.id.bCameraShot);
        Button share = (Button) findViewById(R.id.bShare);
        Button back = (Button) findViewById(R.id.bBack);

        final Context context = this;


        newImage.setOnClickListener(new View.OnClickListener() {
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


        saveImage.setOnClickListener(new View.OnClickListener() {
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

                 Toast.makeText(SettingsActivity.this, "Folder: "+s, Toast.LENGTH_SHORT).show();

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


        loadImage.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(SettingsActivity.this, "Folder: "+s, Toast.LENGTH_SHORT).show();

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

        cameraShot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 0);
               }
        });


        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, ShareActivity.class);
                startActivity(i);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {
            Bundle ex = data.getExtras();
            bitmap = (Bitmap)ex.get("data");

            ModelRoot.getRoot().setBitmap(bitmap);
            setResult(3, getIntent());
            SettingsActivity.this.finish();

            Context context = getApplicationContext();
            context.getContentResolver().delete(data.getData(), null, null);
        }
    }







}