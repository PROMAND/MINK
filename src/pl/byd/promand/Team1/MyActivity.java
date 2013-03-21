package pl.byd.promand.Team1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import android.view.*;
import android.widget.*;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.internal.view.menu.ActionMenu;
import com.actionbarsherlock.view.*;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.promand.Team1.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.*;

public class MyActivity extends SherlockActivity {

    public static SurfaceViewDraw view;
    Context context = this;
    private Dialog start;
    String path;
    private Button tools;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.upbutton2: {
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
                break;
            }
            case R.id.upbutton4: {
                taptoshare();
            }
            default: {
                break;
            }
        }
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Main screen (bottom buttons)
        tools = (Button) findViewById(R.id.button1);
        Button width = (Button) findViewById(R.id.button2);
        width.setText(width.getText() + ": " + ModelRoot.getRoot().getWidth());
        Button colors = (Button) findViewById(R.id.button3);
        Button settings = (Button) findViewById(R.id.button4);

        tools.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog toolD = new Dialog(MyActivity.this);
                toolD.setTitle("Select a tool");
                toolD.setContentView(R.layout.activity_tools);
                toolD.show();

                final ImageButton btnBrush = (ImageButton) toolD.findViewById(R.id.button1);
                final ImageButton btnPen = (ImageButton) toolD.findViewById(R.id.button4);
                final ImageButton btnEraser = (ImageButton) toolD.findViewById(R.id.button3);
                final ImageButton btnFiller = (ImageButton) toolD.findViewById(R.id.button2);
                final ImageButton btnLine = (ImageButton) toolD.findViewById(R.id.button6);
                final ImageButton btnCurvedLine = (ImageButton) toolD.findViewById(R.id.button5);
                final ImageButton btnText = (ImageButton) toolD.findViewById(R.id.button7);
                final ImageButton btnCircle = (ImageButton) toolD.findViewById(R.id.button8);
                final ImageButton btnRectangle = (ImageButton) toolD.findViewById(R.id.button9);

                btnBrush.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToastMessage("BRUSH has been chosen");
                        ModelRoot.getRoot().setTool(1);
                        ModelRoot.getRoot().setToolI(btnBrush.getDrawable());
                        toolD.dismiss();
                    }


                });

                btnPen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToastMessage("PEN has been chosen");
                        ModelRoot.getRoot().setTool(2);
                        ModelRoot.getRoot().setToolI(btnPen.getDrawable());
                        toolD.dismiss();
                    }


                });

                btnEraser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToastMessage("ERASER has been chosen");
                        ModelRoot.getRoot().setTool(6);
                        ModelRoot.getRoot().setToolI(btnEraser.getDrawable());
                        toolD.dismiss();
                    }


                });

                btnFiller.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToastMessage("FILLER has been chosen");
                        ModelRoot.getRoot().setBackColor(ModelRoot.getRoot().getColor());
                        ModelRoot.getRoot().setToolI(btnFiller.getDrawable());
                        toolD.dismiss();
                    }


                });

                btnLine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToastMessage("LINE has been chosen");
                        ModelRoot.getRoot().setTool(3);
                        ModelRoot.getRoot().setToolI(btnLine.getDrawable());
                        toolD.dismiss();
                    }
                });

                btnCurvedLine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToastMessage("CURVED LINE has been chosen");
                        ModelRoot.getRoot().setTool(8);
                        ModelRoot.getRoot().setToolI(btnCurvedLine.getDrawable());
                        toolD.dismiss();
                    }


                });

                btnText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToastMessage("TEXT has been chosen");
                        ModelRoot.getRoot().setTool(9);
                        ModelRoot.getRoot().setToolI(btnText.getDrawable());
                        toolD.dismiss();
                    }


                });

                btnCircle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToastMessage("CIRCLE has been chosen");
                        ModelRoot.getRoot().setTool(4);
                        ModelRoot.getRoot().setToolI(btnCircle.getDrawable());
                        toolD.dismiss();
                    }


                });

                btnRectangle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToastMessage("RECTANGLE has been chosen");
                        ModelRoot.getRoot().setTool(5);
                        ModelRoot.getRoot().setToolI(btnRectangle.getDrawable());
                        toolD.dismiss();
                    }
                });

                toolD.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        tools.setCompoundDrawables(null, null, ModelRoot.getRoot().getToolI(), null);
                    }
                });
            }
        });

        width.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Dialog dialogWidth = new Dialog(context);

                dialogWidth.setContentView(R.layout.activity_width_main);
                SeekBar bar = (SeekBar) dialogWidth.findViewById(R.id.seekbar);
                final TextView txtNumbers = (TextView) dialogWidth.findViewById(R.id.TextView01);
                Button SetWidth = (Button) dialogWidth.findViewById(R.id.bSetWidth);


                SetWidth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogWidth.dismiss();
                    }
                });

                dialogWidth.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        Button widthB = (Button) findViewById(R.id.button2);
                        widthB.setText("Width: " + ModelRoot.getRoot().getWidth());
                    }
                });

                bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onStopTrackingTouch(SeekBar arg0) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar arg0) {

                    }

                    @Override
                    public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                        txtNumbers.setText(String.valueOf(arg1));
                        ModelRoot.getRoot().setWidth(String.valueOf(arg1));
                    }
                });

                dialogWidth.show();
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

        view = new SurfaceViewDraw(this);
        view.setBackgroundColor(Color.WHITE);
        LinearLayout layout = (LinearLayout) findViewById(R.id.forSurfaceViewDraw);
        layout.addView(view);
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
        }
    }

    private void showToastMessage(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);

        toast.show();

    }

    public void taptoshare() {
//        View content = findViewById(R.id.SurfaceViewLayout);
        View content = MyActivity.view;
        content.setDrawingCacheEnabled(true);
        Bitmap bitmap = content.getDrawingCache();
        File file = new File(getExternalCacheDir(), "image.jpg");
        try {
            file.createNewFile();
            FileOutputStream ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
            ostream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");

        share.putExtra(Intent.EXTRA_STREAM,
                Uri.parse("file:///" + file.getAbsolutePath()));

        startActivity(Intent.createChooser(share, "Share Image"));

    }

}