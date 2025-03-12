package com.example.get

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CreateUserScreen(userViewModel: UserViewModel = viewModel()) {
    var phone by remember { mutableStateOf("") }
    var countryId by remember { mutableStateOf("") }
    val response by userViewModel.response.collectAsState()

    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone") }
        )
        TextField(
            value = countryId,
            onValueChange = { countryId = it },
            label = { Text("Country ID") }
        )
        Button(onClick = {
            Log.d("CreateUserScreen", "Phone: $phone ID: $countryId")
            if (phone.isNotEmpty() && countryId.isNotEmpty()) {
                userViewModel.createUser2(phone, countryId)
                Log.d("CreateUserScreens", "API call")
            } else {
                Log.d("CreateUserScreens", "Phone or Country ID is empty!")
            }
        })
        {
            Text("submit")
        }
        response?.let {
            Text("Phone: ${it.phone}, Country ID: ${it.countryId}")
        } ?: run {
            Text("Waiting for response or an error occurred")
        }
    }
}
