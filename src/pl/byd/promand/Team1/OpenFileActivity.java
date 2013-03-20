package pl.byd.promand.Team1;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockActivity;
import com.promand.Team1.R;

import java.io.File;
import java.util.ArrayList;

public class OpenFileActivity extends SherlockActivity {

    private ArrayList<String> fileContent;
    private ListView fileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load);
        setResult(4, getIntent());
        fileList = (ListView) findViewById(R.id.fileList);

        create(ModelRoot.getRoot().getFilePath());

        fileList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ModelRoot.getRoot().setFilePath(ModelRoot.getRoot().getPreviousPath().
                            get(ModelRoot.getRoot().getPreviousPath().size()-1));
                    ModelRoot.getRoot().getPreviousPath().remove(ModelRoot.getRoot().getPreviousPath().
                            get(ModelRoot.getRoot().getPreviousPath().size()-1));
                    create(ModelRoot.getRoot().getFilePath());
                } else {
                    File file = new File(fileContent.get(position));
                    if (file.isDirectory()) {
                        ModelRoot.getRoot().getPreviousPath().add(ModelRoot.getRoot().getFilePath());
                        ModelRoot.getRoot().setFilePath(file.getPath());
                        create(ModelRoot.getRoot().getFilePath());
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

    public void create(String path) {
        fileContent = listFiles(path);
        fileList.removeAllViewsInLayout();
        fileList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fileContent));
    }
}