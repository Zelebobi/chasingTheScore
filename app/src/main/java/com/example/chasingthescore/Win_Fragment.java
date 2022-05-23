package com.example.chasingthescore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Win_Fragment extends Fragment {
    private Button btnInGame;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_win_, container, false);
        btnInGame = view.findViewById(R.id.btnInGame);
        Level_Fragment lf1 = new Level_Fragment(getContext());
        btnInGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f2 = new Main_Game_Fragment();
                FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.container, f2);
                ft1.commit();
            }
        });
        return view;
    }
}