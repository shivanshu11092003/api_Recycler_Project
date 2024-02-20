package com.example.shoppingapp

data class Data(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)