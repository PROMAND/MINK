package pl.byd.promand.Team1;


import android.app.Dialog;
import android.content.Context;
import android.os.Environment;
import android.view.View;
import android.widget.*;
import com.promand.Team1.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Folders extends MyActivity {


   public File currentPath;
   public int numberOfFolders;

    public Folders(){};

    public void setCurrentPath(File path){
          currentPath = path;
    }

    public int getNumberOfFolders(){
        return numberOfFolders;
    }


    public ArrayList<String> getListOfFolders(){      //path no. 1 is getExternalStorageDirectory();

       ArrayList<String> listOfFolders = new ArrayList<String>();


           numberOfFolders=0;
           File listOfFiles[] = currentPath.listFiles();

           if (!(listOfFiles.length==0))
           {
           for (File file : listOfFiles)
           {
               if (file.isDirectory()) {
                   listOfFolders.add(file.getPath());
                   numberOfFolders++;
                   }
           }

       }

       return listOfFolders;
    }



}
