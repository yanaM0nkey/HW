package com.gmail.ioanna.myandroidapp.dz14;


import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.databinding.SpinnerBinding;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz14Country;

import java.util.ArrayList;

public class Dz14SpinnerAdapter extends BaseAdapter {

    ArrayList<Dz14Country> countries;

    public Dz14SpinnerAdapter(ArrayList<Dz14Country> countries) {
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return countries.size();
    }


    @Override
    public Object getItem(int position) {
        if (position >= countries.size())
            return countries.get(0);
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        Dz14ItemViewModel viewModel;

        if (convertView == null) {
            SpinnerBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                    R.layout.spinner, parent, false);

            holder = new ViewHolder(itemBinding);
            holder.view = itemBinding.getRoot();
            holder.view.setTag(holder);
            viewModel = new Dz14ItemViewModel(countries.get(position));
            holder.binding.setViewModel(viewModel);
        }else {
            holder = (ViewHolder) convertView.getTag();
            holder.binding.getViewModel().setCountry(countries.get(position));
        }
        return holder.view;
    }

    static class ViewHolder {
        private View view;

        private SpinnerBinding binding;

        ViewHolder(SpinnerBinding binding) {
            this.view = binding.getRoot();
            this.binding = binding;
        }

    }
}
