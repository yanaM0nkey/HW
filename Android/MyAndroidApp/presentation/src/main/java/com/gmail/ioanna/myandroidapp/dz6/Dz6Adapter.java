package com.gmail.ioanna.myandroidapp.dz6;


import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.dz5.Dz5Activity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Dz6Adapter extends RecyclerView.Adapter<Dz6Adapter.Holder> {

    private ArrayList<String> items;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Dz6Adapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycle_view, parent, false);
        Log.e("Aaaa", "onCreateViewHolder()");
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        Log.e("AAAA", "onBindViewHolder() position = " + position);
        final String item = items.get(position);
        holder.progressBar.setVisibility(View.VISIBLE);
        Picasso.with(holder.imageView.getContext()).load(item).into(holder.imageView, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                holder.progressBar.setVisibility(View.VISIBLE);
            }
        });
        //holder.imageView - заполнить дома
        //holder.textView.setText(item);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(listener !=null){
                    listener.onItemClick(item);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    } //количестко элементов

    public static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        //TextView textView;
        ProgressBar progressBar;

        public Holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            //textView = (TextView) itemView.findViewById(R.id.textView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.GONE);
        }

    }

    interface OnItemClickListener {
        public void onItemClick(String item);
    }
}
