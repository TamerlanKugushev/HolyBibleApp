package com.example.holybibleapp.presentation

import com.example.holybibleapp.core.Book
import com.example.holybibleapp.domain.BooksDomainToUiMapper
import com.example.holybibleapp.domain.ErrorType

class BaseBooksDomainToUiMapper(
    private val communication: BooksCommunication,
    private val resourceProvider: ResourceProvider
) :
    BooksDomainToUiMapper {

    override fun map(books: List<Book>): BooksUi {
        return BooksUi.Success(communication, books)
    }

    override fun map(errorType: ErrorType): BooksUi {
        return BooksUi.Fail(communication, errorType, resourceProvider)
    }
}