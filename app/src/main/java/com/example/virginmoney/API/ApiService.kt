package com.example.virginmoney.API


import com.example.virginmoney.model.people.PeopleItem
import com.example.virginmoney.model.rooms.RoomItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/room")
    suspend fun getRoom() : Response<RoomItem>

    @GET("/people")
    suspend fun getPeople() : Response<PeopleItem>
}