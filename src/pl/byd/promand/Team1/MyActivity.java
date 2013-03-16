package pl.byd.promand.Team1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import com.promand.Team1.R;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
                               //
      Context context = this;

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
    }
}