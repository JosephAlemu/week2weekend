package com.example.user.week2weekendproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentOne extends Fragment {




    private Button startBtn;
    private Button stopBtn;
    private int counter = 0;
    Communications communications;
    boolean flag = false;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_one, parent,false);
        startBtn = (Button) view.findViewById(R.id.btnStart);
        stopBtn = (Button) view.findViewById(R.id.btnStop);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                flag = true;
                new Thread(new Runnable() {
                    @Override
                    public void run() {


                        while (flag)
                        {   counter++;

                            communications.listener("" + counter);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();



            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                flag = false;
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{

            communications =(Communications)context;
        }catch (ClassCastException castException){

            Log.e("onAttach FragmentOne", "MainActivity didn't implement the Communications interface");

        }
    }



}
