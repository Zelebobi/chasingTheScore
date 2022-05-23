package com.example.chasingthescore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Level_Fragment extends Fragment {
    private Context context;
    private Button btnBack1, btnEasy, btnMiddle, btnHard;
    private int count1 = 0;

    public Level_Fragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_, container, false);
        btnBack1 = view.findViewById(R.id.btnBack);
        btnEasy = view.findViewById(R.id.easy);
        btnMiddle = view.findViewById(R.id.middle);
        btnHard = view.findViewById(R.id.hard);
        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1=0;
                choiceGame();
            }
        });
        btnMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1=1;
                choiceGame();
            }
        });
        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1=2;
                choiceGame();
            }
        });

        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBack();
            }
        });
        return view;
    }

    public void choiceGame() {
        String game = getArguments().getString("game");
        switch (game) {
            case "math":
                goToMath();
                break;
            case "attention":
                goToAttention();
                break;
        }
    }
    public void goToMath(){
        Fragment f8 = new Math_Fragment();
        FragmentTransaction ft8 = getActivity().getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("game1","math");
        switch (count1) {
            case 0:
                bundle.putString("level", "easy");
                break;
            case 1:
                bundle.putString("level", "middle");
                break;
            case 2:
                bundle.putString("level", "hard");
                break;
        }

        f8.setArguments(bundle);
        ft8.replace(R.id.container, f8);
        ft8.commit();
    }
    public void goToAttention(){
        Fragment f9 = new Attention_Fragment();
        FragmentTransaction ft9 = getActivity().getSupportFragmentManager().beginTransaction();
        Bundle bundle1 = new Bundle();
        switch (count1) {
            case 0:
                bundle1.putString("level", "easy");
                break;
            case 1:
                bundle1.putString("level", "middle");
                break;
            case 2:
                bundle1.putString("level", "hard");
                break;
        }
        f9.setArguments(bundle1);
        ft9.replace(R.id.container, f9);
        ft9.commit();
    }
    public void goToBack(){
        Fragment f2 = new Main_Game_Fragment();
        FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
        ft1.replace(R.id.container, f2);
        ft1.commit();
    }
}