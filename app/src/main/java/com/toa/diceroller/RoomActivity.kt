package com.toa.diceroller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.toa.diceroller.adapter.RoomAdapter
import com.toa.diceroller.entity.Room
import kotlinx.android.synthetic.main.activity_room.*
import org.json.JSONArray
import com.google.gson.Gson
import org.json.JSONObject

class RoomActivity : AppCompatActivity() {

    private val roomList = ArrayList<Room>()
    lateinit var addRoomButton: Button
    lateinit var adapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        initRooms()
        setUpAdapter()

        addRoomButton = findViewById(R.id.AddRoom)
        addRoomButton.setOnClickListener{ addRoom() }
    }

    private fun addRoom(){
        val addCount = roomList.last().roomId.inc()
        val addName = "Room" + roomList.last().roomId.inc().toString()
        val addImage = R.drawable.dice_3
        val newRoom = Room(addCount,addName, addImage)
        roomList.add(newRoom)
        adapter.insertRoom(addCount, roomList)

        val jsonArray = JSONArray()
        val jsonObject = JSONObject()
        for(i in 0 until roomList.size){
            jsonArray.put(Gson().toJson(roomList[i]))
        }

        var editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
        editor.putString("room", jsonObject.put("list", jsonArray).toString())
        Log.d("room", jsonObject.put("list", jsonArray).toString())
        editor.apply()
    }

    private fun initRooms(){
        Log.d("initRooms","initRooms")

        val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
        val listArray = JSONArray(prefs.getString("room","[]"))
        for(i in 0 until listArray.length()){
            val item = Gson().fromJson(listArray[i].toString(), Room::class.java)
            roomList.add(item)
        }
    }

    private fun setUpAdapter(){
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        roomView.layoutManager = layoutManager
        adapter = RoomAdapter(roomList)
        roomView.adapter = adapter
    }
}