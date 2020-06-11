package com.example.myfirstapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class ThirdFragment extends Fragment {

    TextView showCountTextView;
    int Ai_pts =0;
    int Player_pts =0;
    String point="";
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    )
    {
        View fragmentThirdLayout = inflater.inflate(R.layout.fragment_third, container, false);
        // Inflate the layout for this fragment
        showCountTextView = fragmentThirdLayout.findViewById(R.id.result);
        return fragmentThirdLayout;
    }

    @Override
    public void onStop() {
        super.onStop();
        int Ai_pts =0;
        int Player_pts =0;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });
        view.findViewById(R.id.player_rock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Play(1);
                display("AI: " + Ai_pts + " | " +"You: "+Player_pts);

            }
        });
        view.findViewById(R.id.player_scissor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Play(2);
                display("AI: " + Ai_pts + " | " +"You: "+Player_pts);
            }
        });
        view.findViewById(R.id.player_paper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Play(0);
                display("AI: " + Ai_pts + " | " +"You: "+Player_pts);
            }
        });
    }

private void Play(int OPTION){

    Random rand = new Random();
    int AI = rand.nextInt(3);
    String uni[] = {"\uD83D\uDCB0","\uD83D\uDD28","\u2702"};



    if(OPTION == 0 && AI == 1)
    {
        Player_pts++;
        Toast t = Toast.makeText(getActivity(), uni[AI] +" You Win!", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP,0,300);
        t.show();

    }
    else if(OPTION == 1 && AI == 2)
    {
        Player_pts++;
        Toast t = Toast.makeText(getActivity(), uni[AI] +" You Win!", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP,0,300);
        t.show();

    }
    else if(OPTION == 2 && AI == 0)
    {
        Player_pts++;
        Toast t = Toast.makeText(getActivity(), uni[AI] +" You Win!", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP,0,300);
        t.show();

    }
    else if (OPTION == AI)
    {
        Toast t = Toast.makeText(getActivity(), uni[AI] +" Draw!", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP,0,300);
        t.show();
        return;
    }
    else {
        Ai_pts++;
        Toast t = Toast.makeText(getActivity(), uni[AI] +" You Lose!", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP,0,300);
        t.show();

    }

}

    private void display(String display) {
        showCountTextView.setText(display);
    }
}