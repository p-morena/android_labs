package com.example.task_10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FragmentB extends Fragment {

    ImageView imageView;


    public FragmentB() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b, container, false);
       imageView= (ImageView) view.findViewById(R.id.imgView);
        // Inflate the layout for this fragment
        return view;
    }
}