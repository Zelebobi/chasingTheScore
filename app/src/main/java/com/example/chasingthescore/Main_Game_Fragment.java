package com.example.chasingthescore;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Main_Game_Fragment extends Fragment {
    private Button btnMath,btnAttention,btnBack;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main__game_, container, false);
        btnMath = view.findViewById(R.id.btnmath);
        btnAttention = view.findViewById(R.id.btnatten);
        btnBack = view.findViewById(R.id.btnBack1);
        btnMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f1 = new Level_Fragment(getContext());
                FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("game","math");
                f1.setArguments(bundle);
                ft1.replace(R.id.container,f1);
                ft1.commit();
            }
        });
        btnAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f2 = new Level_Fragment(getContext());
                FragmentTransaction ft2 = getActivity().getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("game","attention");
                f2.setArguments(bundle);
                ft2.replace(R.id.container,f2);
                ft2.commit();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f3 = new Main_Fragment();
                FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.container,f3);
                ft1.commit();
            }
        });
        return view;
    }

}