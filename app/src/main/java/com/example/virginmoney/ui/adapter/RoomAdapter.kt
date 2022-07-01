package com.example.virginmoney.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.databinding.RoomListBinding
import com.example.virginmoney.model.rooms.Room
import com.example.virginmoney.model.rooms.RoomItem

class RoomAdapter (
    private val roomList: MutableList<RoomItem> = mutableListOf()

    ): RecyclerView.Adapter<RoomAdapter.RoomViewHolder>(){

        @SuppressLint("NotifyDataChanged")
        fun setRoomList(newList: Room, updateList: Boolean){
            if(updateList){
                roomList.addAll(newList)
                notifyItemRangeChanged(0,itemCount)
            }else{
                roomList.clear()
                roomList.addAll(newList)
                //works like notifySetChange but without the warning
                notifyItemRangeChanged(0,itemCount)
            }
        }
        class RoomViewHolder(
            private val binding: RoomListBinding
        ): RecyclerView.ViewHolder(binding.root){
            fun onBind(item: RoomItem){
                binding.tvId.text = item.id
                binding.tvBoolean.text = item.isOccupied.toString()
                binding.tvLimit.text = item.maxOccupancy.toString()
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
            return RoomViewHolder(
                RoomListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
            holder.onBind(roomList[position])
        }

        override fun getItemCount(): Int = roomList.size

}