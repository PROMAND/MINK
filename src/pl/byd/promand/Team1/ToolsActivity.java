package pl.byd.promand.Team1;

import android.content.res.Configuration;
import android.widget.ImageButton;
import com.actionbarsherlock.app.SherlockActivity;
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

public class ToolsActivity extends SherlockActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);



        setResult(5, getIntent());

    }


    /** Called when the user touches the button */
    /**
     * public void testing(View v) {
     * if(v.getId() == R.id.button1)
     * {
     * MessageBox("Testing works fine");
     * }
     * }
     * <p/>
     * public void MessageBox(String message)
     * {
     * Toast.makeText(this, message, Toast.LENGTH_SHORT);
     * }
     */

}
