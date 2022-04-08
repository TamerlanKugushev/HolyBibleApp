package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book
import com.example.holybibleapp.data.net.BookCloud
import com.example.holybibleapp.domain.BookDomain
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

interface BooksDataToDomainMapper : Abstract.Mapper {

    fun map(books: List<Book>): BookDomain

    fun map(exception: Exception): BookDomain

//    class Base : BooksDataToDomainMapper {
//        override fun map(books: List<BookCloud>): BookDomain {
//            // todo
//            return BookDomain.Success()
//        }
//
//        override fun map(exception: Exception): BookDomain {
//            // todo
//            val errorType = when(exception){
//                is UnknownHostException -> 0
//                is HttpException -> 1
//                else -> 2
//            }
//            return BookDomain.Fail(errorType)
//        }
//    }
}