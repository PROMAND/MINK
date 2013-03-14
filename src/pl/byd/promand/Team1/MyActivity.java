package pl.byd.promand.Team1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.promand.Team1.R;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

            Intent i = new Intent(getApplicationContext(),SettingsActivity.class);
            startActivity(i);

    }
}
