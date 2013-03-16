package pl.byd.promand.Team1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.promand.Team1.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorChange extends MyActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_selector);

        final SeekBar redSeek = (SeekBar) findViewById(R.id.seekBarRed);
        final SeekBar greenSeek = (SeekBar) findViewById(R.id.seekBarGreen);
        final SeekBar blueSeek = (SeekBar) findViewById(R.id.seekBarBlue);

        redSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView redText = (TextView) findViewById(R.id.redInNumbers);
                redText.setText(String.valueOf(progress));

                EditText hexColor = (EditText) findViewById(R.id.colorInHex);
                String r = Integer.toHexString(progress).length() < 2 ? 0 + Integer.toHexString(progress) : Integer.toHexString(progress);
                String g = Integer.toHexString(greenSeek.getProgress()).length() < 2 ? 0 + Integer.toHexString(greenSeek.getProgress()) :
                        Integer.toHexString(greenSeek.getProgress());
                String b = Integer.toHexString(blueSeek.getProgress()).length() < 2 ? 0 + Integer.toHexString(blueSeek.getProgress()) :
                        Integer.toHexString(blueSeek.getProgress());
                String hexCode = r + g + b;
                hexColor.setText("#" + hexCode.toUpperCase());
                EditText hexField = (EditText) findViewById(R.id.colorInHex);
                hexField.setBackgroundColor(Color.parseColor("#" + hexCode));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        greenSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView greenText = (TextView) findViewById(R.id.greenInNumbers);
                greenText.setText(String.valueOf(progress));

                EditText hexColor = (EditText) findViewById(R.id.colorInHex);
                String r = Integer.toHexString(redSeek.getProgress()).length() < 2 ? 0 + Integer.toHexString(redSeek.getProgress()) :
                        Integer.toHexString(redSeek.getProgress());
                String g = Integer.toHexString(progress).length() < 2 ? 0 + Integer.toHexString(progress) : Integer.toHexString(progress);
                String b = Integer.toHexString(blueSeek.getProgress()).length() < 2 ? 0 + Integer.toHexString(blueSeek.getProgress()) :
                        Integer.toHexString(blueSeek.getProgress());
                String hexCode = r + g + b;
                hexColor.setText("#" + hexCode.toUpperCase());
                EditText hexField = (EditText) findViewById(R.id.colorInHex);
                hexField.setBackgroundColor(Color.parseColor("#" + hexCode));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        blueSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView blueText = (TextView) findViewById(R.id.blueInNumbers);
                blueText.setText(String.valueOf(progress));

                EditText hexColor = (EditText) findViewById(R.id.colorInHex);
                String r = Integer.toHexString(redSeek.getProgress()).length() < 2 ? 0 + Integer.toHexString(redSeek.getProgress()) :
                        Integer.toHexString(redSeek.getProgress());
                String g = Integer.toHexString(greenSeek.getProgress()).length() < 2 ? 0 + Integer.toHexString(greenSeek.getProgress()) :
                        Integer.toHexString(greenSeek.getProgress());
                String b = Integer.toHexString(progress).length() < 2 ? 0 + Integer.toHexString(progress) :
                        Integer.toHexString(progress);
                String hexCode = r + g + b;
                hexColor.setText("#" + hexCode.toUpperCase());
                EditText hexField = (EditText) findViewById(R.id.colorInHex);
                hexField.setBackgroundColor(Color.parseColor("#" + hexCode));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        Button selectColor = (Button) findViewById(R.id.selectB);
        selectColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText hexColor = (EditText) findViewById(R.id.colorInHex);
                String color = hexColor.getText().toString();
                if (color.length() > 5 && color.length() < 8) {
                    Pattern p = Pattern.compile("[0-9a-fA-F]{6}");
                    Matcher m = p.matcher(color);
                    if (m.find() && m.group().length() == 6) {
                        if (color.length() == 6) {
                            color = "#" + color;
                        }
                        ModelRoot.getRoot().setColor(color);
                        Toast.makeText(ColorChange.this, "Color selected", 5000).show();
                        setResult(1, getIntent());
                        finish();
                    } else {
                        final AlertDialog.Builder alert = new AlertDialog.Builder(ColorChange.this);
                        alert.setTitle("Error!");
                        alert.setMessage("Please enter a valid hexadecimal color representation");
                        alert.setCancelable(true);
                        alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        alert.show();
                    }
                } else {
                    final AlertDialog.Builder alert = new AlertDialog.Builder(ColorChange.this);
                    alert.setTitle("Error!");
                    alert.setMessage("Please enter a valid hexadecimal color representation");
                    alert.setCancelable(true);
                    alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alert.show();
                }
            }
        });


        final EditText hexField = (EditText) findViewById(R.id.colorInHex);
        hexField.clearFocus();

        hexField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hexField.setText("");
            }
        });

        hexField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String color = hexField.getText().toString();
                hexField.setText("#" + hexField.getText().toString());
                if (color.length() == 6) {
                    Pattern p = Pattern.compile("[0-9a-fA-F]+");
                    Matcher m = p.matcher(color);
                    if (m.find() && m.group().length() == 6) {

                        String colorPart = m.group();
                        String red = colorPart.substring(0, 1);
                        String green = colorPart.substring(2, 3);
                        String blue = colorPart.substring(4, 5);

                        redSeek.setProgress(Integer.parseInt(red, 16));
                        greenSeek.setProgress(Integer.parseInt(green, 16));
                        blueSeek.setProgress(Integer.parseInt(blue, 16));

                        ModelRoot.getRoot().setColor(color);
                        setResult(1, getIntent());
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        final EditText hexField = (EditText) findViewById(R.id.colorInHex);
        hexField.clearFocus();
    }
}
