package pl.byd.promand.Team1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.promand.Team1.R;

public class WidthMainActivity extends SherlockActivity {

    SeekBar bar;
    TextView txtNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_width_main);
        bar = (SeekBar) findViewById(R.id.seekbar);
        txtNumbers = (TextView) findViewById(R.id.TextView01);

        Button SetWidth = (Button)findViewById(R.id.bSetWidth);

        SetWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub

                txtNumbers.setText(String.valueOf(arg1));
                ModelRoot.getRoot().setWidth(String.valueOf(arg1));
				setResult(2, getIntent());

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getSupportMenuInflater().inflate(R.layout.activity_width_main, menu);

        return true;
    }


}
