package com.liliane.workoutlog.api

import com.liliane.workoutlog.models.RegisterRequest
import com.liliane.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest):Call<RegisterResponse>
}