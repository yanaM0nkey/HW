package com.gmail.ioanna.myandroidapp.classwork6;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.ioanna.myandroidapp.R;

import java.util.ArrayList;

public class Classwork6Adapter extends RecyclerView.Adapter<Classwork6Adapter.Holder>{
    private ArrayList<String> items;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Classwork6Adapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view, parent, false);
        Log.e("Aaaa", "onCreateViewHolder()");
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.e("AAAA", "onBindViewHolder() position = " + position);
        final String item = items.get(position);
        //holder.imageView - заполнить дома
        holder.textView.setText(item);

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
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public Holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    interface OnItemClickListener {
        public void onItemClick(String item);
    }

}
