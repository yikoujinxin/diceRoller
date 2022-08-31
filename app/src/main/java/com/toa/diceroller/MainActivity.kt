package com.toa.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView
    var randomInt by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate execute")

        val rollButton: Button = findViewById<Button>(R.id.roll_button);
        rollButton.setOnClickListener { rollDice() }
        val clearButton: Button = findViewById<Button>(R.id.clear_button);
        clearButton.setOnClickListener { backDevice() }

        diceImage = findViewById<ImageView>(R.id.dice_image);
        diceImage2 = findViewById<ImageView>(R.id.dice_image2);

        //----------device
        val bundle = this.intent.extras
        randomInt = bundle?.get("diceInt") as Int
        Log.d("diceInt", bundle?.get("diceInt").toString())
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun rollDice(){
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun clearDice(){
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }

    private fun backDevice(){
        var intent: Intent = Intent(this, RoomActivity::class.java)
        startActivity(intent)
    }

    private fun getRandomDiceImage():Int{
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