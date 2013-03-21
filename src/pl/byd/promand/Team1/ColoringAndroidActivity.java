package pl.byd.promand.Team1;

/**
 * Created with IntelliJ IDEA.
 * User: Mark
 * Date: 19/03/13
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnTouchListener;
import com.promand.Team1.R;

public class ColoringAndroidActivity extends Activity implements OnTouchListener{
    /** Called when the activity is first created. */
    private ImageView imageView;
    private Canvas cv;
    private Bitmap mask, original, colored;
    private int r,g,b;
    private int sG, sR, sB;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //((ImageView)findViewById(R.id.coringImage)).setImageDrawable(R.drawable.original);
        imageView = (ImageView)findViewById(R.drawable.logopic2);
        imageView.setOnTouchListener(this);

        mask = BitmapFactory.decodeResource(getResources(), R.drawable.logopic2); // Mask Image
        original = BitmapFactory.decodeResource(getResources(), R.drawable.logopic2); // Original Image Without Color

        colored = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Config.ARGB_8888);
        //cv = new Canvas(colored);
        //cv.drawBitmap(original, 0,0, null);
        cv = new Canvas(colored);
        cv.drawBitmap(original, 0,0, null);
        imageView.setImageBitmap(original);

    }

    int ANTILAISING_TOLERANCE = 70;

    public boolean onTouch(View arg0, MotionEvent arg1) {
        //mask = BitmapFactory.decodeResource(getResources(), R.drawable.mask);
        int selectedColor = mask.getPixel((int)arg1.getX(),(int)arg1.getY());
        sG = (selectedColor & 0x0000FF00) >> 8;
        sR = (selectedColor & 0x00FF0000) >> 16;
        sB = (selectedColor & 0x000000FF);
        System.out.println("SG :"+((selectedColor & 0x0000FF00) >> 8));
        System.out.println("SR :"+((selectedColor & 0x00FF0000) >> 16));
        System.out.println("SB :"+(selectedColor & 0x000000FF));

        //original = BitmapFactory.decodeResource(getResources(), R.drawable.original);
//              colored = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Config.ARGB_8888);

        for(int x = 0; x < mask.getWidth(); x++){
            for(int y = 0; y < mask.getHeight(); y++){

                g = (mask.getPixel(x,y) & 0x0000FF00) >> 8;
                r = (mask.getPixel(x,y) & 0x00FF0000) >> 16;
                b = (mask.getPixel(x,y) & 0x000000FF);

                //System.out.println("r: "+r+", g: "+g+", b: "+b);


                if(Math.abs(sR - r) < ANTILAISING_TOLERANCE && Math.abs(sG - g) < ANTILAISING_TOLERANCE && Math.abs(sB - b) < ANTILAISING_TOLERANCE)
                    colored.setPixel(x, y, (colored.getPixel(x, y) & 0xFFFF0000));
            }
        }

        imageView.setImageBitmap(colored);
        imageView.invalidate();
        return true;
    }
}