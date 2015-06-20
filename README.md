# AndroidGeneralRecyclerView
Creating a RecyclerViewAdapter to prevent boilerplate code.

This code offers you one main class to extend and create your own recyler view adapter implementation. Based on [Renderers](https://github.com/pedrovgs/Renderers)

#How to use

GeneralRecyclerView contais  all the methods to work with List.

In your Adapter you just need to worry with your items, it means, 
you need to implement your ViewHolder and render all the fields for your model. As example, we can create your
listViewAdapter as follows:

As dependency view injection we're using ButterKnife, but you don't need to use that, you can implement that just using your findViewById methods.

```java
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
```

#TODO
 - Create an adapter for other types, such as SortedList or HashMap.
