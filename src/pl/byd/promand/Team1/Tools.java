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

     Button btnBrush;
     Button btnPen;
     Button btnEraser;
     Button btnFiller;
     Button btnLine;
     Button btnCurvedLine;
     Button btnText;
     Button btnCircle;
     Button btnRectangle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tools);

       btnBrush = (Button)findViewById(R.id.button1);
       btnPen = (Button) findViewById(R.id.button4);
       btnEraser = (Button) findViewById(R.id.button3);
       btnFiller = (Button) findViewById(R.id.button2);
       btnLine = (Button) findViewById(R.id.button6);
       btnCurvedLine = (Button) findViewById(R.id.button5);
       btnText = (Button) findViewById(R.id.button7);
       btnCircle =  (Button) findViewById(R.id.button8);
       btnRectangle= (Button) findViewById(R.id.button9);

       btnBrush.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showToastMessage("BRUSH has chosen");
               //super.onBackPressed();
               ModelRoot.getRoot().setTool("brush");
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

                Intent intent = new Intent();
                //setResult(RESULT_OK, intent);
                finish();

            }


        });


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
