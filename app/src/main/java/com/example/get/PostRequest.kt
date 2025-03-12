package com.example.get

data class PostRequest(
    val address: String,
    val countryId: String,
    val city: String = "",
    val lat: String = "",
    val long: String= "",
    val notificationAllow: String = "",
    val phone: String=""
)
