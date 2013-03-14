package pl.byd.promand.Team1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.promand.Team1.R;

public class ShareActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);

        Button share = (Button) findViewById(R.id.shareB);
        Button cancel = (Button) findViewById(R.id.cancelB2);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShareActivity.this, "Image shared in checked social networks", 3000).show();
                Intent i = new Intent(ShareActivity.this, SettingsActivity.class);
                startActivity(i);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShareActivity.this, SettingsActivity.class);
                startActivity(i);
            }
        });
    }
}
