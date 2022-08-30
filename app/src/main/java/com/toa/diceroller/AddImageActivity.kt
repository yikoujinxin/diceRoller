package com.toa.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout

class AddImageActivity : AppCompatActivity() {

    lateinit var devices_group: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_image)
    }

    fun addDeviceImage(){
        val imageView = ImageView(this)

        imageView.setImageResource(R.drawable.dice_2)
    }
}