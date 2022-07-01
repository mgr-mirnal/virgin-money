package com.example.virginmoney.ui.fragments


import androidx.fragment.app.Fragment
import com.example.virginmoney.databinding.FragmentRoomBinding

class RoomFragment : Fragment() {

    private var _binding: FragmentRoomBinding? = null

    private val binding get() = _binding!!



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}