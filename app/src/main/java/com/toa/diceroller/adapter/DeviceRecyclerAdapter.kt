package com.toa.diceroller.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.toa.diceroller.R
import com.toa.diceroller.entity.Device

class DeviceRecyclerAdapter(val deviceList: List<Device>):
    RecyclerView.Adapter<DeviceRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val deviceId: TextView = view.findViewById(R.id.deviceId)
        val deviceName: TextView = view.findViewById(R.id.deviceName)
        val deviceImage: ImageView = view.findViewById(R.id.deviceImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.device_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val device = deviceList[position]
        holder.deviceId.text = device.deviceId.toString()
        holder.deviceImage.setImageResource(device.deviceImageId)
        holder.deviceName.text = device.deviceName
    }

    override fun getItemCount() = deviceList.size
}