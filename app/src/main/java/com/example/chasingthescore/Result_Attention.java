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
import android.widget.TextView;
import android.widget.Toast;


public class Result_Attention extends Fragment {
    private EditText attentionEdit;
    private Button attentionbtn;
    private TextView attentionText;
    private String question[] = {"Сколько кругов?","Сколько ромбов?","Сколько квадратов?","Сколько Шестиугольников?","Сколько треугольников?","Сколько раз фон был белым?","Сколько раз фон был чёрным?","Сколько раз фон был зелёным?","Сколько раз фон был жёлтым?"};

    private LinearLayout attentionLinear;
    private int numberQuestion;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.attention_result, container, false);
        attentionLinear = view.findViewById(R.id.attentionLinear);
        attentionEdit = view.findViewById(R.id.attentionEdit);
        attentionbtn = view.findViewById(R.id.attentionBtn);
        attentionText = view.findViewById(R.id.attentionText);

        int resultcir = getArguments().getInt("resultcir",0);
        int resultrom = getArguments().getInt("resultrom",0);
        int resultsqr = getArguments().getInt("resultsqr",0);
        int resultshs = getArguments().getInt("resultshs",0);
        int resulttre = getArguments().getInt("resulttre",0);
        int resultwhite = getArguments().getInt("resultwhite",0);
        int resultblack = getArguments().getInt("resultblack",0);
        int resultgreen = getArguments().getInt("resultgreen",0);
        int resultyellow = getArguments().getInt("resultyellow",0);
        numberQuestion = getArguments().getInt("numberQuestion",0);

        attentionText.setText(randomQuestion());
        attentionLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setEnabled(false);
            }
        });
        attentionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!attentionEdit.getText().toString().equals("")){
                    final int polresult = Integer.parseInt(attentionEdit.getText().toString().trim());
                    switch (numberQuestion){
                        case 0:
                            if(resultcir==polresult){
                                winFragment();
                            }
                            else{
                                loseFragment();
                            }
                            break;
                        case 1:
                            if(resultrom==polresult){
                                winFragment();
                            }
                            else{
                                loseFragment();
                            }
                            break;
                        case 2:
                            if(resultsqr==polresult){
                                winFragment();
                            }
                            else{
                                loseFragment();
                            }
                            break;
                        case 3:
                            if(resultshs==polresult){
                                winFragment();
                            }
                            else{
                                loseFragment();
                            }
                            break;
                        case 4:
                            if(resulttre==polresult){
                                winFragment();
                            }
                            else{
                                loseFragment();
                            }
                            break;
                        case 5:
                            if(resultwhite==polresult){
                                winFragment();
                            }
                            else{
                                loseFragment();
                            }
                            break;
                        case 6:
                            if(resultblack==polresult){
                                winFragment();
                            }
                            else{
                                loseFragment();
                            }
                            break;
                        case 7:
                            if(resultgreen==polresult){
                                winFragment();
                            }
                            else{
                                loseFragment();
                            }
                            break;
                        case 8:
                            if(resultyellow==polresult){
                                winFragment();
                            }
                            else{
                                loseFragment();
                            }
                            break;
                    }



                }
                else{
                    Toast.makeText(getActivity(),"Введите результат",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void winFragment(){
        Fragment f = new Win_Fragment();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,f);
        ft.commit();
    }
    private void loseFragment(){
        Fragment f1 = new Fail_Fragment();
        FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
        ft1.replace(R.id.container,f1);
        ft1.commit();
    }
    private String randomQuestion(){
        String Question = question[numberQuestion];
        return Question;
    }
}