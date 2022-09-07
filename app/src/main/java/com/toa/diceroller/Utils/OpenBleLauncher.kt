package com.toa.diceroller.Utils

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.toa.diceroller.R

class OpenBleLauncher : AppCompatActivity() {

    val openBLELauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                Toast.makeText(this, "Have bluetooth permission!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Not have bluetooth permission!", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        val button1: Button = findViewById<Button>(R.id.add_button)

        button1.setOnClickListener {
            val bluetoothManager =
                this.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
            val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.getAdapter()
            if (bluetoothAdapter == null) {
                Log.d("BluetoothAdapter", "The Device doesn't support Bluetooth")
            } else {
                if (bluetoothAdapter.isEnabled == false) {
                    openBLELauncher.launch(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE))
                }
            }
        }
    }
}