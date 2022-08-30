package com.toa.diceroller.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.toa.diceroller.R
import com.toa.diceroller.entity.Device

class DeviceAdapter(activity: Activity, val resourceId: Int, data: List<Device>):
    ArrayAdapter<Device>(activity, resourceId, data){

    inner class ViewHolder(val deviceId: TextView, val deviceName: TextView, val deviceImage: ImageView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if(convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val deviceId: TextView = view.findViewById<TextView>(R.id.deviceId)
            val deviceImage: ImageView = view.findViewById<ImageView>(R.id.deviceImage)
            val deviceName: TextView = view.findViewById<TextView>(R.id.deviceName)
            viewHolder = ViewHolder(deviceId, deviceName, deviceImage)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val device = getItem(position) //获取当前项的Device实例
        if(device != null){
            viewHolder.deviceId.text = device.deviceId.toString()
            viewHolder.deviceImage.setImageResource(device.deviceImageId)
            viewHolder.deviceName.text = device.deviceName
        }
        return view
    }
}