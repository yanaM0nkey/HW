package com.gmail.ioanna.myandroidapp.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class BaseItemViewHolder<Model,
        ViewModel extends BaseItemViewModel<Model>, DataBinding extends ViewDataBinding>
        extends RecyclerView.ViewHolder{

    private DataBinding dataBinding;
    private ViewModel viewModel;

    public BaseItemViewHolder(DataBinding dataBinding, ViewModel viewModel) {
        super(dataBinding.getRoot());
        this.viewModel = viewModel;
        this.dataBinding = dataBinding;
        viewModel.init();
    }

    public void bindTo(Model item, int position){
        viewModel.setItem(item,position);
        dataBinding.executePendingBindings();
    }

    public void release(){
        viewModel.release();
    }
}
