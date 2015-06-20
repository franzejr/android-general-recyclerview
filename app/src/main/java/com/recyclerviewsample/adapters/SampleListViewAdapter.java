package com.recyclerviewsample.adapters;

import android.content.Context;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recyclerviewsample.R;
import com.recyclerviewsample.model.Sample;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by franzejr on 16/06/15.
 */
public class SampleListViewAdapter extends GeneralRecyclerViewAdapter<Sample> {


    public SampleListViewAdapter(Context context, List<Sample> sampleList) {
        super(context, sampleList);
    }

    @Override
    public SampleRowHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sample_item, null);
        SampleRowHolder mh = new SampleRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Sample sample = simpleList.get(position);

        renderTitle(sample, (SampleRowHolder) holder);
        renderContent(sample, (SampleRowHolder) holder);
    }

    /*
        Render Methods for each field
     */
    private void renderTitle(Sample sample, SampleRowHolder holder) {
        holder.titleSample.setText(sample.getTitle());
    }

    private void renderContent(Sample sample, SampleRowHolder holder) {
        holder.contentSample.setText(sample.getContent());
    }


    public class SampleRowHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.titleSample)
        TextView titleSample;
        @InjectView(R.id.contentSample)
        TextView contentSample;

        public SampleRowHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
