package com.example.chasingthescore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Inst_Math_Fragment extends Fragment {
    private Button understand;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inst__math_, container, false);
        understand = view.findViewById(R.id.understand);
        understand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f1 = new Rules_Fragment();
                FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.container,f1);
                ft1.commit();
            }
        });
        return view;
    }
}