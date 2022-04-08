package com.example.holybibleapp.data.cache

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book

interface BooksCacheMapper : Abstract.Mapper {

    fun map(books: List<BookDb>): List<Book>

    class Base(private var mapper: BookCacheMapper) : BooksCacheMapper {
        override fun map(books: List<BookDb>): List<Book> {
            return books.map { bookDb ->
                bookDb.map(mapper)
            }
        }
    }
}