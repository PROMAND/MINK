package pl.byd.promand.Team1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.app.Activity;
//import android.content.Intent;
//import java.io.ByteArrayOutputStream;

 /**
 * Created with IntelliJ IDEA.
 * User: Kasia
 * Date: 14.03.13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class CameraShot extends Activity {

    Intent i;
    Bitmap bitmap;

    public void takePhoto() {

        i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {
            Bundle ex = data.getExtras();
            Bitmap bit;
            bit = (Bitmap)ex.get("data");


            //Matrix matrix = new Matrix();
           // matrix.postRotate(90);

           // bitmap = Bitmap.createBitmap(bit, 0, 0,bit.getWidth(),bit.getHeight(),matrix,true);


            // ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            // bit2.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

            //Context context = getApplicationContext();
            //context.getContentResolver().delete(data.getData(), null, null);
        }
    }

    public Bitmap getBitmap(){
        return bitmap;
    }

}