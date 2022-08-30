package com.toa.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import com.toa.diceroller.adapter.DeviceAdapter
import com.toa.diceroller.entity.Device
import kotlinx.android.synthetic.main.activity_devices_list.*

class DevicesListActivity : AppCompatActivity() {

    private val devicesList = mutableListOf<Device>()
    lateinit var addDeviceButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devices_list)
        Log.d("DevicesListActivity", "onCreate execute")

        initDevices()
        val deviceAdapter = DeviceAdapter(this,
            R.layout.device_item, devicesList)
        devicesListView.adapter = deviceAdapter
        devicesListView.setOnItemClickListener { _, _, position, _ ->
            val device = devicesList[position]
            Toast.makeText(this, device.deviceName, Toast.LENGTH_LONG).show()
        }
        addDeviceButton = findViewById(R.id.AddDevice)
        addDeviceButton.setOnClickListener{ addDevice() }

    }

    private fun addDevice(){
        val addCount = devicesList.last().deviceId.inc()
        val addName = "Device" + devicesList.last().deviceId.inc().toString()
        val addImage = R.drawable.dice_3
        devicesList.add(Device(addCount,addName, addImage))
        val deviceAdapter = DeviceAdapter(this,
            R.layout.device_item, devicesList)
        devicesListView.adapter = deviceAdapter
    }

    private fun initDevices(){
        devicesList.add(Device(1,"Device1", R.drawable.dice_1))
        devicesList.add(Device(2,"Device2", R.drawable.dice_2))
    }

}