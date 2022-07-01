package com.example.virginmoney.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.virginmoney.viewModel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class ViewModelFragment :Fragment() {
       protected val viewModel: ViewModel by activityViewModels()
}