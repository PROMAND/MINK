package pl.byd.promand.Team1;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

public class ModelRoot {
    private String color = "#FFFFFF";
    private String width = "1";
    private Bitmap bitmap;
    private String filePath;
    private String previousPath;      //required for OpenFileActivity... and probably for saving file
    private boolean landscape = false;
    private  String tool="pen";
    private Drawable toolI;

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getPreviousPath() {
        return previousPath;
    }

    public void setPreviousPath(String previousPath) {
        this.previousPath = previousPath;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool){
        this.tool =tool;
    }

    public  Drawable getToolI() {
        return toolI;
    }

    public  void setToolI(Drawable toolI){
        this.toolI=toolI;

    }

    public boolean isLandscape() {
        return landscape;
    }

    public void setLandscape(boolean landscape) {
        this.landscape = landscape;
    }
}


