package com.example.user.week2weekendproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentTwo extends Fragment {


    TextView tvDisplayCounter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_two, container,false);
        tvDisplayCounter = (TextView) v.findViewById(R.id.tvDisplayCounter);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void updateCounter(String data){
        tvDisplayCounter.setText(data);
    }

}
