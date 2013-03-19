package pl.byd.promand.Team1;

import android.widget.ImageButton;
import com.promand.Team1.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class Tools extends Activity {

     ImageButton btnBrush;
     ImageButton btnPen;
     ImageButton btnEraser;
     ImageButton btnFiller;
     ImageButton btnLine;
     ImageButton btnCurvedLine;
     ImageButton btnText;
     ImageButton btnCircle;
     ImageButton btnRectangle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tools);

       btnBrush = (ImageButton) findViewById(R.id.button1);
       btnPen = (ImageButton) findViewById(R.id.button4);
       btnEraser = (ImageButton) findViewById(R.id.button3);
       btnFiller = (ImageButton) findViewById(R.id.button2);
       btnLine = (ImageButton) findViewById(R.id.button6);
       btnCurvedLine = (ImageButton) findViewById(R.id.button5);
       btnText = (ImageButton) findViewById(R.id.button7);
       btnCircle =  (ImageButton) findViewById(R.id.button8);
       btnRectangle= (ImageButton) findViewById(R.id.button9);

       btnBrush.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showToastMessage("BRUSH has chosen");
               //super.onBackPressed();
               ModelRoot.getRoot().setTool("brush");
               ModelRoot.getRoot().setToolI(btnBrush.getDrawable());

               Intent intent = new Intent();
               //setResult(RESULT_OK, intent);
               finish();

           }


       });

        btnPen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMessage("PEN has chosen");
                //super.onBackPressed();
                ModelRoot.getRoot().setTool("pen");
                ModelRoot.getRoot().setToolI(btnPen.getDrawable());
                Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                finish();

            }


        });

        btnEraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMessage("ERASER has chosen");
                //super.onBackPressed();
                ModelRoot.getRoot().setTool("eraser");
                ModelRoot.getRoot().setToolI(btnEraser.getDrawable());
                Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                finish();

            }


        });

        btnFiller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMessage("FILLER has chosen");
                //super.onBackPressed();
                ModelRoot.getRoot().setTool("filler");
                ModelRoot.getRoot().setToolI(btnFiller.getDrawable());
                Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                finish();

            }


        });

        btnLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMessage("LINE has chosen");
                //super.onBackPressed();
                ModelRoot.getRoot().setTool("fill");
                ModelRoot.getRoot().setToolI(btnLine.getDrawable());
                Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                finish();

            }


        });

        btnCurvedLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMessage("CURVED LINE has chosen");
                //super.onBackPressed();
                ModelRoot.getRoot().setTool("curved_line");
                ModelRoot.getRoot().setToolI(btnCurvedLine.getDrawable());
                Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                finish();

            }


        });

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMessage("TEXT has chosen");
                //super.onBackPressed();
                ModelRoot.getRoot().setTool("text");
                ModelRoot.getRoot().setToolI(btnText.getDrawable());
                Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                finish();

            }


        });

        btnCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMessage("CIRCLE has chosen");
                //super.onBackPressed();
                ModelRoot.getRoot().setTool("circle");
                ModelRoot.getRoot().setToolI(btnCircle.getDrawable());
                Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                finish();

            }


        });

        btnRectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMessage("RECTANGLE has chosen");
                //super.onBackPressed();
                ModelRoot.getRoot().setTool("rectangle");
                ModelRoot.getRoot().setToolI(btnRectangle.getDrawable());
                Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                finish();

            }


        });

        setResult(5,getIntent());

	}


    /** Called when the user touches the button */
    /** public void testing(View v) {
        if(v.getId() == R.id.button1)
        {
            MessageBox("Testing works fine");
        }
    }

    public void MessageBox(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT);
    }

            */
    private void showToastMessage(String msg){

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);

        toast.show();

    }
}
