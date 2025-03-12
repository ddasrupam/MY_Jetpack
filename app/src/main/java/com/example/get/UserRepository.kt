package com.example.get

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
class UserRepository {
    private val apiService = RetrofitInstance.api

    suspend fun createUser1(phone: String, countryId: String): PostRequest {
        return withContext(Dispatchers.IO) //network request
        {

            val requests = PostRequest(phone, countryId)
            Log.d("UserRepo", "Phone: $phone, Country ID: $countryId")
            apiService.createUser(requests)


        }
    }
}




