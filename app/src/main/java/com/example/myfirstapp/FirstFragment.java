package com.example.myfirstapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

public class FirstFragment extends Fragment {

    private int count = 0;
    private boolean reset = false;
    TextView showCountTextView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        showCountTextView = fragmentFirstLayout.findViewById(R.id.display_counts); // Inflate the layout for this fragment
        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRandom();

            }
        });

        view.findViewById(R.id.count).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCount();
            }
        });

        view.findViewById(R.id.count).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                getReset();
                return false;
            }
        });

        view.findViewById(R.id.timer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        view.findViewById(R.id.RPS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_ThirdFragment);
            }
        });
        view.findViewById(R.id.TTT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_ForthFragment);
            }
        });
    }

    public void getRandom() {
        Random ran = new Random();
        int x = ran.nextInt(10);
        Toast t = Toast.makeText(getActivity(), "Your random number is: "+ String.valueOf(x), Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP,0,200);
        t.show();


    }
    public void getCount() {
        if(!this.reset) {
            this.count++;
            String display = String.valueOf(this.count);
            showCountTextView.setText(display);
        }
        else{
            this.reset = false;
        }
    }

    public void getReset()
    {
        this.reset = true;
        this.count = 0;
        String display = String.valueOf(this.count);
        showCountTextView.setText(display);
    }

}