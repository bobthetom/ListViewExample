package com.robert_soulchin.listviewexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] favoriteTVShows = {"Pushing Dasisies",
                "Better Off Ted",
                "Twin Peaks",
                "Orphan Black",
                "Walking Dead",
                "Breaking Bad",
                "The 400",
                "Alphas",
                "life on Mars"};
  //      ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,
//        favoriteTVShows);
//        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.textView1,
//                favoriteTVShows);
        ListAdapter theAdapter = new MyAdapter(this, favoriteTVShows);

        ListView theListView = (ListView) findViewById(R.id.theListView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener
                    (new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String tvShowPicked = "You selected " +
                                    String.valueOf(parent.getItemAtPosition(position));
                            Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();
                        }
                    });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
