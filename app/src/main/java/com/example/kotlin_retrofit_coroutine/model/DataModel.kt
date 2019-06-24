package com.example.kotlin_retrofit_coroutine.model

data class DataModel(
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)