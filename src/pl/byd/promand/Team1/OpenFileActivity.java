package pl.byd.promand.Team1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.promand.Team1.R;

import java.io.File;
import java.util.ArrayList;

public class OpenFileActivity extends Activity {

    private ArrayList<String> fileContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load);
        setResult(4, getIntent());
        ListView fileList = (ListView) findViewById(R.id.fileList);

        fileContent = listFiles(ModelRoot.getRoot().getFilePath());

        fileList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fileContent));

        fileList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ModelRoot.getRoot().setFilePath(ModelRoot.getRoot().getPreviousPath());
                   // recreate();

                } else {
                    File file = new File(fileContent.get(position));
                    if (file.isDirectory()) {
                        ModelRoot.getRoot().setPreviousPath(ModelRoot.getRoot().getFilePath());
                        ModelRoot.getRoot().setFilePath(file.getPath());
                  //      recreate();
                    }
                    if (file.isFile() && file.getPath().endsWith(".jpg")) {
                        ModelRoot.getRoot().setFilePath(file.getPath());
                        finish();
                    }
                }
            }
        });
    }

    public ArrayList<String> listFiles(String path) {
        ArrayList<String> content = new ArrayList<String>();
        content.add("/..");
        File rootFile = new File(path);

        if (rootFile.isDirectory()) {
            for (File file : rootFile.listFiles()) {
                if (file.isDirectory() || (file.isFile() && file.getPath().endsWith(".jpg"))) {
                    content.add(file.getPath());
                }
            }
        }

        return content;
    }
}