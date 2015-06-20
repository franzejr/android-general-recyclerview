package com.recyclerviewsample.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.recyclerviewsample.R;
import com.recyclerviewsample.adapters.SampleListViewAdapter;
import com.recyclerviewsample.model.Sample;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.rv_sample)
    RecyclerView recyclerView;
    private SampleListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new SampleListViewAdapter(this, createObjects());

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    private List<Sample> createObjects() {
        List<Sample> sampleList = new ArrayList<Sample>();

        for (int i = 0; i < 20; i++) {
            sampleList.add(new Sample("title" + i, "content" + i));
        }
        return sampleList;
    }

}
