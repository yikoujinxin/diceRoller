package com.toa.diceroller.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.toa.diceroller.MainActivity
import com.toa.diceroller.R
import com.toa.diceroller.entity.Device

class DeviceRecyclerAdapter(var deviceList: List<Device>):
    RecyclerView.Adapter<DeviceRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val deviceId: TextView = view.findViewById(R.id.deviceId)
        val deviceName: TextView = view.findViewById(R.id.deviceName)
        val deviceImage: ImageView = view.findViewById(R.id.deviceImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.device_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition
            val device = deviceList[position]
            Toast.makeText(parent.context, "you clicked view ${device.deviceName}",
            Toast.LENGTH_SHORT).show()

            var intent :Intent = Intent(viewHolder.itemView.context, MainActivity::class.java)
            intent.putExtra("diceInt", device.deviceId)
            viewHolder.itemView.context.startActivity(intent)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val device = deviceList[position]
        holder.deviceId.text = device.deviceId.toString()
        holder.deviceImage.setImageResource(device.deviceImageId)
        holder.deviceName.text = device.deviceName
    }

    override fun getItemCount() = deviceList.size

    fun insertDevice(newDeviceId: Int, newDeviceList: List<Device>){
        deviceList = newDeviceList
        notifyItemInserted(newDeviceId)
    }

    fun updateDevice(index: Int, newDeviceList: List<Device>){
        deviceList = newDeviceList
        notifyItemChanged(index)
    }

    fun removeDevice(position: Int, newDeviceList: List<Device>){
        deviceList = newDeviceList
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }
}