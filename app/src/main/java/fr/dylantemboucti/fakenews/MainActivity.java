package fr.dylantemboucti.fakenews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<FakeNews> list = FakeNewsList.all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRecyclerView();
    }

    private void setRecyclerView(){
        final RecyclerView rv = (RecyclerView) findViewById(R.id.list_item);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter());
    }
}
