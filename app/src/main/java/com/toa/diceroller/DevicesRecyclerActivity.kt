package com.toa.diceroller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    lateinit var adapter: DeviceRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devices_recycler)

        initDevices()
        setUpAdapter()

        addDeviceButton = findViewById(R.id.AddDevice)
        addDeviceButton.setOnClickListener{ addDevice() }
    }

    private fun addDevice(){
        val addCount = deviceList.last().deviceId.inc()
        val addName = "Device" + deviceList.last().deviceId.inc().toString()
        val addImage = R.drawable.dice_3
        deviceList.add(Device(addCount,addName, addImage))
        adapter.insertDevice(addCount, deviceList)

//        var editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
//        editor.putInt("deviceId", 1)
//        editor.putString("deviceName", "Device1")
//        editor.putInt("deviceImageId", R.drawable.dice_1)
//        editor.apply()
    }

    private fun initDevices(){
        Log.d("initDevices","initDevices")

        val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
        val deviceId = prefs.getInt("deviceId", 2)
        val deviceName = prefs.getString("deviceName", "Device2")
        val deviceImageId = prefs.getInt("deviceImageId", 2131165286)
        deviceList.add(Device(deviceId,deviceName!!, deviceImageId))
    }

    private fun setUpAdapter(){
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        adapter = DeviceRecyclerAdapter(deviceList)
        recyclerView.adapter = adapter
    }
}