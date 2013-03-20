package pl.byd.promand.Team1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;

import android.view.*;
import android.widget.*;
import com.promand.Team1.R;

import java.util.ArrayList;

public class MyActivity extends Activity {

    public static SurfaceViewDraw view;
    Context context = this;
    private Dialog start;
    String path;
    private Button tools;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Start dialog
        start = new Dialog(context);
        start.setTitle("Let's start");
        start.setContentView(R.layout.start_dialog);
        start.setCancelable(false);
        start.show();

        ImageButton newFile = (ImageButton) start.findViewById(R.id.newButton);
        ImageButton openFile = (ImageButton) start.findViewById(R.id.loadButton);
        ImageButton takeAPhoto = (ImageButton) start.findViewById(R.id.takeAPhotoButton);
        Button exit = (Button) start.findViewById(R.id.exitB);

        newFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.dismiss();
            }
        });

        openFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.dismiss();
                ModelRoot.getRoot().setFilePath("/mnt");
                Intent i = new Intent(context, OpenFileActivity.class);
                startActivityForResult(i, 4);
            }
        });

        takeAPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 0);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Main screen (bottom buttons)
        tools = (Button) findViewById(R.id.button1);
        Button width = (Button) findViewById(R.id.button2);
        width.setText(width.getText() + ": " + ModelRoot.getRoot().getWidth());
        Button colors = (Button) findViewById(R.id.button3);
        Button settings = (Button) findViewById(R.id.button4);

        tools.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, ToolsActivity.class);
                startActivityForResult(i,5);
            }
        });

        width.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, WidthMainActivity.class);
                startActivityForResult(i, 2);
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, ColorChangeActivity.class);
                startActivityForResult(i, 1);
            }
        });


        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, SettingsActivity.class);
                startActivityForResult(i, 3);

            }
        });

        //Main screen (top buttons) - will be replaced with Action bar
        ImageButton addNew = (ImageButton) findViewById(R.id.upbutton2);
        ImageButton saveButton = (ImageButton) findViewById(R.id.upbutton3);
        ImageButton shareButton = (ImageButton) findViewById(R.id.upbutton4);

        addNew.setOnClickListener(new View.OnClickListener() {
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

        saveButton.setOnClickListener(new View.OnClickListener() {
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

                        Toast.makeText(MyActivity.this, "Folder: " + s, Toast.LENGTH_SHORT).show();

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

        view = new SurfaceViewDraw(this);
        view.setBackgroundColor(Color.WHITE);
        Display display = getWindowManager().getDefaultDisplay();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(display.getWidth(), (display.getHeight()-150));
        addContentView(view, params);
    }

    //Functionality
    @Override
    protected void onResume() {
        super.onResume();
      
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1) {
            start.dismiss();
        }

        if (resultCode == 2) {
            start.dismiss();
            Button widthB = (Button) findViewById(R.id.button2);
            widthB.setText("Width: " + ModelRoot.getRoot().getWidth());
        }

        if (resultCode == 3) {
            start.dismiss();
        }

        if (resultCode == 4) {
            view.setBackgroundDrawable(Drawable.createFromPath(ModelRoot.getRoot().getFilePath()));
            start.dismiss();
        }

        if(resultCode==5){
            tools.setCompoundDrawables(null, null, ModelRoot.getRoot().getToolI(), null);
            start.dismiss();
        }

    }
}