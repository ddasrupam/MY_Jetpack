package com.example.get

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {
    private val repository = UserRepository()

    private val _response = MutableStateFlow<PostRequest?>(null)
    val response: StateFlow<PostRequest?> get() = _response

    fun createUser2(phone: String, countryId: String) {
        viewModelScope.launch {
            try {
                val result = repository.createUser1(phone, countryId)
                _response.value = result
                Log.d("result", " result $result")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
