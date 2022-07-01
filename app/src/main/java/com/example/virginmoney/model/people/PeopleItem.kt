package com.example.virginmoney.model.people

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PeopleItem(
    val avatar: String,
    val createdAt: String,
    //val `data`: Data,
    val email: String,
    val favouriteColor: String,
    val firstName: String,
    val fromName: String,
    val id: String,
    val jobtitle: String,
    val lastName: String,
    val to: String
):Parcelable
