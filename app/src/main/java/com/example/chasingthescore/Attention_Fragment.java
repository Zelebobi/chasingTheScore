package com.example.chasingthescore;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


public class Attention_Fragment extends Fragment {


    private Integer figury[] = {R.drawable.circle, R.drawable.romb, R.drawable.square, R.drawable.shestiug, R.drawable.treug};
    private Integer color[] = {R.color.white, R.color.black, R.color.green, R.color.yellow};


    private ImageView imageView;
    private Handler handler;

    private int tm;
    private int kolvo = 0;
    private int square = 0;
    private int treug = 0;
    private int shstiug = 0;
    private int circle = 0;
    private int romb = 0;
    private int green = 0;
    private int white = 0;
    private int black = 0;
    private int yellow = 0;
    private int count = 0;
    private String TAG = "TAG";
    private int Number;
    private TextView attentionText;
    private LinearLayout attentionFragmentLinear;
    private Long curentTime, stopTime;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention_, container, false);
        curentTime = System.currentTimeMillis() / 1000;
        imageView = view.findViewById(R.id.image);
        attentionFragmentLinear = view.findViewById(R.id.attentionFragmentLinear);
        attentionText = view.findViewById(R.id.attentionText);
        attentionFragmentLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setEnabled(false);
            }
        });
        handler = new Handler();
        String level = getArguments().getString("level");
        if (level != null) {
            switch (level) {
                case "easy":
                    count = 0;
                    Number = (int) (Math.random() * 4);
                    handler.post(showInfo);
                    break;
                case "middle":
                    count = 1;
                    Number = (int) (Math.random() * 4);
                    handler.post(showInfo);
                    break;
                case "hard":
                    count = 2;
                    Number = (int) (Math.random() * 8);
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
                Fragment f2 = new Result_Attention();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();

                bundle.putInt("resultcir", circle);
                bundle.putInt("resultsqr", square);
                bundle.putInt("resultrom", romb);
                bundle.putInt("resultshs", shstiug);
                bundle.putInt("resulttre", treug);
                bundle.putInt("resultwhite", white);
                bundle.putInt("resultblack", black);
                bundle.putInt("resultgreen", green);
                bundle.putInt("resultyellow", yellow);
                bundle.putInt("numberQuestion", Number);

                f2.setArguments(bundle);
                ft.replace(R.id.container, f2);
                ft.commit();
            }
            Log.d(TAG, stopTime - curentTime + " " + curentTime + " " + stopTime);
        }
    };

    private void PostHandler(Handler handler) {
        int randomChar = (int) (Math.random() * figury.length);
        int randomColor = (int) (Math.random() * color.length);
        Integer imageStr = figury[randomChar];
        Integer colorStr1 = color[randomColor];
        switch (randomChar) {
            case 0:
                circle += 1;
                break;
            case 1:
                romb += 1;
                break;
            case 2:
                square += 1;
                break;
            case 3:
                shstiug += 1;
                break;
            case 4:
                treug += 1;
                break;
        }
        switch (randomColor) {
            case 0:
                white += 1;
                break;
            case 1:
                black += 1;
                break;
            case 2:
                green += 1;
                break;
            case 3:
                yellow += 1;
                break;
        }
        switch (count) {
            case 0:
                tm = 2000;
                break;
            case 1:
                tm = 1500;
                break;
            case 2:
                tm = 1500;
                break;
        }
        kolvo += 1;
        attentionText.setText("" + kolvo);
        imageView.setImageResource(imageStr);
        attentionFragmentLinear.setBackgroundResource(colorStr1);
        handler.postDelayed(showInfo, tm);
    }


    public void onBackPressed() {
        //super.onBackPressed();
    }
}