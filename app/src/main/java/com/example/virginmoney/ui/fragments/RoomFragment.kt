package com.example.virginmoney.ui.fragments


import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.virginmoney.databinding.FragmentRoomBinding
import com.example.virginmoney.model.rooms.Room
import com.example.virginmoney.ui.ResponseState
import com.example.virginmoney.ui.adapter.RoomAdapter


class RoomFragment : ViewModelFragment() {

    private var _binding: FragmentRoomBinding? = null

    private val binding get() = _binding!!
    private lateinit var roomAdapter: RoomAdapter


    private val shouldUpdateList = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoomBinding.inflate(
            inflater, container, false
        )
        configureObservers()
        return binding.root
    }


    private fun configureObservers(){
    viewModel.getRoomList()
        viewModel.roomResponse.observe(viewLifecycleOwner){
            when(it){
                is ResponseState.SUCCESS<*> ->{
                    renderRoom(it.response as Room)
                }
                is ResponseState.ERROR ->{
                    binding.apply {
                        tvRoomsError.text = "Error"
                        tvRoomsError.visibility = View.VISIBLE
                        pbRoomsLoading.visibility = View.GONE
                    }
                }
                is ResponseState.Loading -> {
                    viewModel.getRoomList()

                }
            }

        }
    }

    private fun renderRoom(response: Room){
        binding.apply {
            pbRoomsLoading.visibility = View.GONE
            rvRoomList.apply {
                // setting the adapter once
                if (!shouldUpdateList) {
                    roomAdapter = RoomAdapter()
                    adapter = roomAdapter
                }
                roomAdapter.setRoomList(response,shouldUpdateList)

            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}