package com.gmail.ioanna.myandroidapp.classwork13;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gmail.ioanna.myandroidapp.R;

public class Classwork13Fragment extends Fragment{

    public static final String TEXT_KEY = "TEXT_KEY";
    private String text;

    public static Classwork13Fragment newInstance(FragmentManager fragmentManager, String text){

        Fragment fragment = fragmentManager.
                findFragmentByTag(Classwork13Fragment.class.getName());
        Classwork13Fragment classwork13Fragment;
        if(fragment != null && fragment instanceof Classwork13Fragment){
            classwork13Fragment = (Classwork13Fragment) fragment;
        }else {
            classwork13Fragment = new Classwork13Fragment();
            Bundle bundle = new Bundle();
            bundle.putString(TEXT_KEY, text);
            classwork13Fragment.setArguments(bundle);
        }

        return classwork13Fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            text = bundle.getString(TEXT_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_classwork13, container, false);
    }

    //все действия делаем здесь
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    //Вызывается когда активити в которой лежит фрагмент создан
    //После этого мтеода можно использовать мтеод getActivity()
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
