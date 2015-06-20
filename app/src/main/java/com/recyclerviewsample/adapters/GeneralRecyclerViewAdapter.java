package com.recyclerviewsample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by franzejr on 20/06/15.
 */
public abstract class GeneralRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> simpleList;
    protected Context context;

    public GeneralRecyclerViewAdapter(Context context, List<T> elements) {
        this.context = context;
        this.simpleList = elements;
    }

    public int getItemCount() {
        return simpleList.size();
    }

    public T get(int position) {
        return simpleList.get(position);
    }

    public boolean add(T item) {
        return simpleList.add(item);
    }

    public int indexOf(T item) {
        return simpleList.indexOf(item);
    }

    public void updateItemAt(int index, T item) {
        simpleList.set(index, item);
    }

    public void addAll(List<T> items) {
        simpleList.clear();
        for (T item : items) {
            simpleList.add(item);
        }
    }

    public void addAll(T[] items) {
        addAll(Arrays.asList(items));
    }

    public boolean remove(T item) {
        return simpleList.remove(item);
    }

    public T removeItemAt(int index) {
        return simpleList.remove(index);
    }

    public void clear() {
        simpleList.clear();
    }
}
