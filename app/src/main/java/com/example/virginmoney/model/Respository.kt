package com.example.virginmoney.model

import com.example.virginmoney.ui.ResponseState
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getRoom() : Flow<ResponseState>
    fun getPeople(): Flow<ResponseState>
}