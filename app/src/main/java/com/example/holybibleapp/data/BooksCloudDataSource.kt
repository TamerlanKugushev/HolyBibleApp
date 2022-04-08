package com.example.holybibleapp.data

import com.example.holybibleapp.data.net.BookCloud
import com.example.holybibleapp.data.net.BooksService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody

interface BooksCloudDataSource {

    suspend fun fetchBooks(): List<BookCloud>

    class Base(private val booksService: BooksService) : BooksCloudDataSource {

        private val gson = Gson()
        private val type = object : TypeToken<List<BookCloud>>() {}.type //todo make a wrapper

        override suspend fun fetchBooks(): List<BookCloud> =
            gson.fromJson(booksService.fetchBooks().string(), type)
    }
}
