package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollbutton = findViewById(R.id.button);
        rollbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
    }

    void rollDice() {
        Dice dice = new Dice(6);
        int diceroll = dice.roll();

        Toast toast= Toast.makeText(getApplicationContext(),"Dice Rolled is " + String.valueOf(diceroll),Toast.LENGTH_SHORT);
        toast.show();

        ImageView diceImage = findViewById(R.id.imageView);
        int resource = 1;
        switch(diceroll) {
            case 1 :
                resource = R.drawable.dice_1;
                break;
            case 2 :
                resource = R.drawable.dice_2;
                break;
            case 3 :
                resource = R.drawable.dice_3;
                break;
            case 4 :
                resource = R.drawable.dice_4;
                break;
            case 5 :
                resource = R.drawable.dice_5;
                break;
            case 6 : resource = R.drawable.dice_6;
                break;
        }

        diceImage.setImageResource(resource);


    }

    class Dice {
        int numSides;

        Dice(int numSides){
            this.numSides = numSides;
        }

        int roll() {
            Random rn = new Random();
            return rn.nextInt(6) + 1;
        }
    }
}