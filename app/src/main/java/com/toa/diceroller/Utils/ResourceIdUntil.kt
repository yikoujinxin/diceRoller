package com.toa.diceroller.Utils

import android.util.Log
import android.widget.ImageView
import java.lang.IllegalArgumentException

object ResourceIdUntil {
    fun getV7ImageResourceId(imageView: ImageView): Int{
        var imageId = 0
        val fields = imageView.javaClass.declaredFields
        for (f in fields){
            if(f.name == "mBackgroundTintHelper"){
                f.isAccessible = true
                try {
                    val obj = f[imageView]
                    val fields2 = obj.javaClass.declaredFields
                    for (f2 in fields2){
                        if(f2.name == "mBackgroundResId"){
                            f2.isAccessible = true
                            imageId = f2.getInt(obj)
                            Log.d("getV7ImageResourceId:", "Image ResourceId:$imageId")
                        }
                    }
                }catch (e: IllegalArgumentException){
                    e.printStackTrace()
                }
            }
        }
        return imageId
    }
}