package com.example.chasingthescore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Rules_Fragment extends Fragment {
    private Button instMath,instAttention,comebackRules;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_rules_, container, false);
        instMath = view.findViewById(R.id.instMath);
        comebackRules = view.findViewById(R.id.comebackRules);
        instAttention = view.findViewById(R.id.instAttention);
        instMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f1 = new Inst_Math_Fragment();
                FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.container,f1);
                ft1.commit();
            }
        });
        instAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f2 = new Inst_Attention_Fragment();
                FragmentTransaction ft2 = getActivity().getSupportFragmentManager().beginTransaction();
                ft2.replace(R.id.container,f2);
                ft2.commit();
            }
        });
        comebackRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = new Main_Fragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container,f);
                ft.commit();
            }
        });
        return view;
    }
}