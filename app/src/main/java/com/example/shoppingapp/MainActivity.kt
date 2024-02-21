package com.example.shoppingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    lateinit var MyRecyclerView :RecyclerView
    lateinit var MyAdapter :MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.Recyclerview)

        val retrofitBuilder= Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Apiinterface::class.java)
        val retrofitdata =retrofitBuilder.getPersonData()
        retrofitdata.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                var response =response.body()
                val personlist = response?.users!!


                MyAdapter= MyAdapter(this@MainActivity,personlist)
                recyclerview.adapter=MyAdapter
                recyclerview.layoutManager=LinearLayoutManager(this@MainActivity)






            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("MainActivity","on Failure"+t.message)

            }

        })







    }
}