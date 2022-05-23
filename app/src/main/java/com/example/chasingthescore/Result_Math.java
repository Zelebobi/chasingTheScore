package com.example.chasingthescore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Result_Math extends Fragment {
    private EditText mathEdit;
    private Button mathBtn;
    private LinearLayout mathLinear;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.math_result_, container, false);

        mathEdit = view.findViewById(R.id.mathEdit);
        mathLinear = view.findViewById(R.id.mathLinear);
        mathBtn = view.findViewById(R.id.mathBtn);
        int trueresult = getArguments().getInt("result",0);
        mathLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setEnabled(false);
            }
        });
        mathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mathEdit.getText().toString().equals("")){
                    final int polresult = Integer.parseInt(mathEdit.getText().toString().trim());
                    if(trueresult==polresult){
                        Fragment f = new Win_Fragment();
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container,f);
                        ft.commit();
                    }
                    else{
                        Fragment f1 = new Fail_Fragment();
                        FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
                        ft1.replace(R.id.container,f1);
                        ft1.commit();
                    }
                }
                else{
                    Toast.makeText(getActivity(),"Введите результат",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}