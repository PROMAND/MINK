package pl.byd.promand.Team1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.actionbarsherlock.app.SherlockActivity;
import com.promand.Team1.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorChangeActivity extends SherlockActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_selector);


    }

    @Override
    protected void onStart() {
        super.onStart();
        final EditText hexField = (EditText) findViewById(R.id.colorInHex);
        hexField.clearFocus();
    }
}
