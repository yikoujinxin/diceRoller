package com.toa.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView;
    lateinit var diceImage2: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate execute")
        Log.d("data", "onCreate execute")

        val rollButton: Button = findViewById<Button>(R.id.roll_button);
        rollButton.setOnClickListener { rollDice() }
        val clearButton: Button = findViewById<Button>(R.id.clear_button);
        clearButton.setOnClickListener { clearDice() }

        diceImage = findViewById<ImageView>(R.id.dice_image);
        diceImage2 = findViewById<ImageView>(R.id.dice_image2);

    }

    private fun rollDice(){
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun clearDice(){
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }
    private fun getRandomDiceImage():Int{
        val randomInt = (1..6).random()
        return when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}