package com.example.chasingthescore;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


public class Math_Fragment extends Fragment {
    private TextView textView;
    private Handler handler;
    private int n, tm;
    private int count = 0;
    private String legkiy[] = new String[]{"+", "-"};
    private String TAG = "TAG";
    private int result = 0;
    private Long curentTime, stopTime;
    private LinearLayout mathFragmentLinear;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_math_, container, false);
        curentTime = System.currentTimeMillis() / 1000;
        textView = view.findViewById(R.id.mathtext);
        mathFragmentLinear = view.findViewById(R.id.mathFragmentLinear);
        mathFragmentLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setEnabled(false);
            }
        });
        handler = new Handler();
        String level = getArguments().getString("level");
        if(level!=null){
            switch(level){
                case "easy":
                    count = 0;
                    handler.post(showInfo);
                    break;
                case  "middle":
                    count = 1;
                    handler.post(showInfo);
                    break;
                case  "hard":
                    count = 2;
                    handler.post(showInfo);
                    break;
            }
        }

        return view;
    }
    Runnable showInfo = new Runnable() {
        @Override
        public void run() {
            stopTime = System.currentTimeMillis() / 1000;
            if ((stopTime - curentTime) < 12)//показывать первые 10 секунд
                PostHandler(handler);
            else {
                Fragment f2 = new Result_Math();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("result", result);
                f2.setArguments(bundle);
                ft.replace(R.id.container,f2);
                ft.commit();
            }
            Log.d(TAG, stopTime - curentTime + " " + curentTime + " " + stopTime);
        }
    };
    private void PostHandler(Handler handler) {
        switch (count) {
            case 0:
                n = (int) (1 + java.lang.Math.random() * 25);
                tm = 3000;
                break;
            case 1:
                n = (int) (1 + java.lang.Math.random() * 50);
                tm = 2000;
                break;
            case 2:
                n = (int) (1 + java.lang.Math.random() * 100);
                tm = 1500;
                break;
        }
        String znak = legkiy[(int) (java.lang.Math.random() * legkiy.length)];
        if (znak == "-") {
            result -= n;
        } else if (znak == "+") {
            result += n;
        }
        textView.setText(znak + " " + n);
        randomColor();
        handler.postDelayed(showInfo, tm);
    }


    private void randomColor() {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        textView.setTextColor(color);
    }



    public void onBackPressed() {
        //super.onBackPressed();
    }
}