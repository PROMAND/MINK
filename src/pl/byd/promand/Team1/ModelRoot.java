package pl.byd.promand.Team1;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 15.03.13
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
public class ModelRoot {
    private String color = "#FFFFFF";
    private String width = "1";
    private Bitmap bitmap;

    private final static ModelRoot root = new ModelRoot();
    public static ModelRoot getRoot() {
         return root;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}


