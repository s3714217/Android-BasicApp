package com.example.myfirstapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;


public class ForthFragment extends Fragment {

    TextView showCountTextView;
    char[][] grid = new char[3][3];
    boolean x_turn = true;
    boolean x_win = false;
    boolean y_win = false;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View fragmentForthLayout = inflater.inflate(R.layout.fragment_forth, container, false);
        //showCountTextView = fragmentForthLayout.findViewById(R.id.grid);
        return fragmentForthLayout;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ForthFragment.this)
                        .navigate(R.id.action_ForthFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.grid_00).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button p1_button = (Button)view.findViewById(R.id.grid_00);

                if(x_turn)
                {p1_button.setText("X");
                grid[0][0] = 'X';
                x_turn = false;}
                else
                {p1_button.setText("O");
                grid[0][0] = 'O';
                x_turn = true;}
            }
        });
        view.findViewById(R.id.grid_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button p1_button = (Button)view.findViewById(R.id.grid_01);
                if(x_turn)
                {p1_button.setText("X");
                    grid[0][1] = 'X';
                    x_turn = false;}
                else
                {p1_button.setText("O");
                    grid[0][1] = 'O';
                    x_turn = true;}
            }
        });
        view.findViewById(R.id.grid_02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button p1_button = (Button)view.findViewById(R.id.grid_02);
                if(x_turn)
                {p1_button.setText("X");
                    grid[0][2] = 'X';
                    x_turn = false;}
                else
                {p1_button.setText("O");
                    grid[0][2] = 'O';
                    x_turn = true;}
            }
        });
        view.findViewById(R.id.grid_10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button p1_button = (Button)view.findViewById(R.id.grid_10);
                if(x_turn)
                {p1_button.setText("X");
                    grid[1][0] = 'X';
                    x_turn = false;}
                else
                {p1_button.setText("O");
                    grid[1][0] = 'O';
                    x_turn = true;}
            }
        });
        view.findViewById(R.id.grid_11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button p1_button = (Button)view.findViewById(R.id.grid_11);
                if(x_turn)
                {p1_button.setText("X");
                    grid[1][1] = 'X';
                    x_turn = false;}
                else
                {p1_button.setText("O");
                    grid[1][1] = 'O';
                    x_turn = true;}
            }
        });
        view.findViewById(R.id.grid_12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button p1_button = (Button)view.findViewById(R.id.grid_12);
                if(x_turn)
                {p1_button.setText("X");
                    grid[1][2] = 'X';
                    x_turn = false;}
                else
                {p1_button.setText("O");
                    grid[1][2] = 'O';
                    x_turn = true;}
            }
        });
        view.findViewById(R.id.grid_20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button p1_button = (Button)view.findViewById(R.id.grid_20);
                if(x_turn)
                {p1_button.setText("X");
                    grid[2][0] = 'X';
                    x_turn = false;}
                else
                {p1_button.setText("O");
                    grid[2][0] = 'O';
                    x_turn = true;}
            }
        });
        view.findViewById(R.id.grid_21).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button p1_button = (Button)view.findViewById(R.id.grid_21);
                if(x_turn)
                {p1_button.setText("X");
                    grid[2][1] = 'X';
                    x_turn = false;}
                else
                {p1_button.setText("O");
                    grid[2][1] = 'O';
                    x_turn = true;}
            }
        });
        view.findViewById(R.id.grid_22).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button p1_button = (Button)view.findViewById(R.id.grid_22);

                if(x_turn)
                {
                    p1_button.setText("X");
                    grid[2][2] = 'X';
                    x_turn = false;}
                else
                {
                    p1_button.setText("O");
                    grid[2][2] = 'O';
                    x_turn = true;}
            }
        });


    }


    private void display(String display) {
        showCountTextView.setText(display);
    }

}