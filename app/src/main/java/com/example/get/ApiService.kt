package com.example.get

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun createUser(@Body postRequest: PostRequest): PostRequest
}

