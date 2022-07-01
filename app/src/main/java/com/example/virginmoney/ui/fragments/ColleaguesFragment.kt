package com.example.virginmoney.ui.fragments

import androidx.fragment.app.Fragment
import com.example.virginmoney.databinding.FragmentColleaguesBinding


class ColleaguesFragment : Fragment() {

    private var _binding: FragmentColleaguesBinding? = null

    private val binding get() = _binding!!



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}