package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {

    private int current_hour = 0;
    private int current_second = 0;
    private int current_minutes = 0;
    private boolean running = false;
    private boolean terminated = false;

    TextView showCountTextView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View fragmentSecondLayout = inflater.inflate(R.layout.fragment_second, container, false);
        // Inflate the layout for this fragment
        showCountTextView = fragmentSecondLayout.findViewById(R.id.clock);
        return fragmentSecondLayout;
    }


    @Override
    public void onStop() {
        super.onStop();
        this.running = false;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        new Thread(new Runnable() {
            public void run() {
                start_counting();
            }
        }).start();

        view.findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true;
            }
        });

        view.findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               stop();
            }
        });

        view.findViewById(R.id.stop).setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                reset();
                display("00:00:00");
                return true;
            }
        });

    }

    private void display(String time){
        showCountTextView.setText(time);
        try{
            Thread.sleep(10);
        }
        catch (InterruptedException e)
        {

        }
    }

    private void start_counting(){

        while(!terminated) {
            if(this.running) {
                display(getTimer());
            }
        }
    }

    private void stop(){
        this.running = false;
    }

    private String getTimer(){


            this.current_second++;
            if(this.current_second == 100)
            {
                this.current_second = 0;
                this.current_minutes ++;
                if(this.current_minutes == 60)
                {
                        this.current_minutes = 0;
                        this.current_hour++;
                }
            }


        String s_second = String.valueOf(this.current_second); ;
        if(this.current_second < 10){
            s_second = "0" + String.valueOf(this.current_second);
        }

        String s_minute = String.valueOf(this.current_minutes); ;
        if(this.current_minutes < 10){
            s_minute = "0" + String.valueOf(this.current_minutes);
        }

        String s_hour = String.valueOf(this.current_hour); ;
        if(this.current_hour < 10){
            s_hour = "0" + String.valueOf(this.current_hour);
        }

        String s_time = s_hour+":"+s_minute+":"+s_second;
        return s_time;
    }

    private void reset()
    {
        this.current_minutes = 0;
        this.current_second = 0;
        this.current_hour = 0;
    }
}