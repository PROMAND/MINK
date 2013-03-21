package pl.byd.promand.Team1;

import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class ModelRoot {
    private boolean start = true;
    private String color = "#000000";
    private String width = "3";
    private String filePath;
    private ArrayList<String> previousPath = new ArrayList<String>();
    private boolean landscape = false;
    private  int tool=3;
    private Drawable toolI;
    private String backgroundColor = "#FFFFF0";

    public Paint paint = new Paint();

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> getPreviousPath() {
        return previousPath;
    }

    public void setPreviousPath(ArrayList<String> previousPath) {
        this.previousPath = previousPath;
    }

    public int getTool() {
        return tool;
    }

    public void setTool(int tool){
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

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint){
        this.paint = paint;
    }

    public String getBackColor() {
        return backgroundColor;
    }

    public void setBackColor(String color) {
        this.backgroundColor = color;
    }

}


