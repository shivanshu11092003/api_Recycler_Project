package com.example.shoppingapp

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {

    @GET("users")
    fun getPersonData(): Call<Data>
}