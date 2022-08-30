package com.toa.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.toa.diceroller.adapter.DeviceAdapter
import com.toa.diceroller.adapter.DeviceRecyclerAdapter
import com.toa.diceroller.entity.Device
import kotlinx.android.synthetic.main.activity_devices_list.*
import kotlinx.android.synthetic.main.activity_devices_recycler.*

class DevicesRecyclerActivity : AppCompatActivity() {

    private val deviceList = ArrayList<Device>()
    lateinit var addDeviceButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devices_recycler)

        initDevices()
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = DeviceRecyclerAdapter(deviceList)
        recyclerView.adapter = adapter
        addDeviceButton = findViewById(R.id.AddDevice)
        addDeviceButton.setOnClickListener{ addDevice() }
    }

    private fun addDevice(){
        val addCount = deviceList.last().deviceId.inc()
        val addName = "Device" + deviceList.last().deviceId.inc().toString()
        val addImage = R.drawable.dice_3
        deviceList.add(Device(addCount,addName, addImage))
        val adapter = DeviceRecyclerAdapter(deviceList)
        recyclerView.adapter = adapter
    }

    private fun initDevices(){
        deviceList.add(Device(1,"Device1", R.drawable.dice_1))
        deviceList.add(Device(2,"Device2", R.drawable.dice_2))
    }
}