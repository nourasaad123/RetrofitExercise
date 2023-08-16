package com.example.productwithapi.data.module

data class UserModel(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)