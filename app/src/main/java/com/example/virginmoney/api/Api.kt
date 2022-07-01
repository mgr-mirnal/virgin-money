package com.example.virginmoney.api

import com.example.virginmoney.model.people.People
import com.example.virginmoney.model.rooms.Room
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/rooms")
    suspend fun getRoom() : Response<Room>

    @GET("/people")
    suspend fun getPeople() : Response<People>
}