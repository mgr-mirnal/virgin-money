package com.example.virginmoney.model

import android.util.Log
import com.example.virginmoney.api.Api
import com.example.virginmoney.ui.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface Repository {
    fun getRoom() : Flow<ResponseState>
    fun getPeople(): Flow<ResponseState>
}

private const val TAG = "Repository"
class RepositoryImp {
    class RepositoryImpl @Inject constructor(
        private val service : Api
    ): Repository{

        override fun getPeople() = flow {
            emit(ResponseState.Loading)
            try{
                val response = service.getPeople()
                if(response.isSuccessful) {
                    response.body()?.let {
                        Log.d(TAG, "getPeople: Success")
                        emit(ResponseState.SUCCESS(it))
                    } ?: throw Exception("Error Null")
                }else {
                    Log.d(TAG, "getPeople: Failure")
                    throw Exception("Error Failure")
                }
            } catch (e: Exception){
                Log.d(TAG, "getPeople: Failure: "+ e.message)
                emit(ResponseState.ERROR(e))
            }

        }

        override fun getRoom()= flow {
            try {
                val response = service.getRoom()
                if (response.isSuccessful){
                    response.body()?.let {
                        emit(ResponseState.SUCCESS(it))
                        Log.d(TAG, "getRoom: Success")
                    }?:throw Exception("Error Nul")
                    Log.d(TAG, "getRoom: Null")
                }else{
                    throw Exception("Error Failure")

                }

            }catch (e : Exception){
                emit(ResponseState.ERROR(e))
                Log.d(TAG, "getRoom: Failure: "+ e.message)
            }
        }


    }
}