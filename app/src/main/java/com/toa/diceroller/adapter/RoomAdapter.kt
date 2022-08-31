package com.toa.diceroller.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.toa.diceroller.MainActivity
import com.toa.diceroller.R
import com.toa.diceroller.entity.Room
import org.json.JSONArray

class RoomAdapter(var roomList: List<Room>):
    RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val roomId: TextView = view.findViewById(R.id.roomId)
        val roomName: TextView = view.findViewById(R.id.roomName)
        val roomImage: ImageView = view.findViewById(R.id.roomImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.room_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition
            val room = roomList[position]
            Toast.makeText(parent.context, "you clicked view ${room.roomName}",
            Toast.LENGTH_SHORT).show()

            var intent :Intent = Intent(viewHolder.itemView.context, MainActivity::class.java)
            intent.putExtra("diceInt", room.roomId)
            viewHolder.itemView.context.startActivity(intent)
        }
        viewHolder.itemView.setOnLongClickListener{
            val position = viewHolder.adapterPosition
            val room = roomList[position]
            AlertDialog.Builder(viewHolder.itemView.context).apply {
                setTitle("是否删除该房间！")
                setMessage("房间号码: ${room.roomName}")
                setCancelable(false)
                setPositiveButton("是"){ dialog, which ->
                    Log.d("which", which.toString())
                    roomList -= listOf<Room>(room)
                    val newRoom = roomList.toString()
                    val jsonArray = JSONArray()
                    removeRoom(position, roomList)
                    var editor = viewHolder.itemView.context.getSharedPreferences("data", Context.MODE_PRIVATE).edit()
                    editor.putString("room", Gson().toJson(roomList).toString())
                    editor.apply()
                }
                setNegativeButton("否"){ dialog, which ->
                    Log.d("which", "no delete")
                }
                show()
            }
            true
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val room = roomList[position]
        holder.roomId.text = room.roomId.toString()
        holder.roomImage.setImageResource(room.roomImageId)
        holder.roomName.text = room.roomName
    }

    override fun getItemCount() = roomList.size

    fun insertRoom(newRoomId: Int, newRoomList: List<Room>){
        roomList = newRoomList
        notifyItemInserted(newRoomId)
    }

    fun updateRoom(index: Int, newRoomList: List<Room>){
        roomList = newRoomList
        notifyItemChanged(index)
    }

    fun removeRoom(position: Int, newRoomList: List<Room>){
        roomList = newRoomList
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }
}