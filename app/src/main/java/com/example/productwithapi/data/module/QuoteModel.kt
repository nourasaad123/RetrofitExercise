package com.example.productwithapi.data.module

data class QuoteModel(
    val limit: Int,
    val quotes: List<QuoteX>,
    val skip: Int,
    val total: Int
)