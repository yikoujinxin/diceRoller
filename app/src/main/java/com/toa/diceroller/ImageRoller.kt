package com.toa.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.toa.diceroller.Utils.ResourceIdUntil

class ImageRoller : AppCompatActivity(), View.OnClickListener {

    lateinit var add_button: Button
    lateinit var image_view: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_roller)

        add_button = findViewById<Button>(R.id.add_button)
        image_view = findViewById<ImageView>(R.id.image_view)
        image_view.setBackgroundResource(R.drawable.dice_1)
        add_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val imageId: Int = ResourceIdUntil.getV7ImageResourceId(image_view)
        when (v?.id) {
            R.id.add_button -> {
                if (imageId == R.drawable.dice_1) {
                    image_view.setImageResource(R.drawable.dice_6)
                    image_view.setBackgroundResource(R.drawable.dice_6)
                } else {
                    image_view.setImageResource(R.drawable.dice_1)
                    image_view.setBackgroundResource(R.drawable.dice_1)
                }
            }
        }
    }
}