package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book
import com.example.holybibleapp.data.net.BookCloud
import com.example.holybibleapp.domain.BookDomain
import java.lang.Exception

sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>() {

    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain {
            return mapper.map(books)
        }
    }

    class Fail(private val exception: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain {
            return mapper.map(exception)
        }
    }
}