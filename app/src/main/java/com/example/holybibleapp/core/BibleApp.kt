package com.example.holybibleapp.core

import android.app.Application
import com.example.holybibleapp.data.BooksCloudDataSource
import com.example.holybibleapp.data.BooksCloudMapper
import com.example.holybibleapp.data.BooksRepository
import com.example.holybibleapp.data.cache.BookCacheMapper
import com.example.holybibleapp.data.cache.BooksCacheDataSource
import com.example.holybibleapp.data.cache.BooksCacheMapper
import com.example.holybibleapp.data.cache.RealmProvider
import com.example.holybibleapp.data.net.BookCloudMapper
import com.example.holybibleapp.data.net.BooksService
import com.example.holybibleapp.domain.BaseBooksDataToDomainMapper
import com.example.holybibleapp.domain.BooksInteractor
import com.example.holybibleapp.presentation.BaseBooksDomainToUiMapper
import com.example.holybibleapp.presentation.BooksCommunication
import com.example.holybibleapp.presentation.MainViewModel
import com.example.holybibleapp.presentation.ResourceProvider
import io.realm.Realm
import retrofit2.Retrofit

class BibleApp : Application() {

    companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    lateinit var mainViewModel: MainViewModel
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()

        val service = retrofit.create(BooksService::class.java)

        val booksCloudDataSource = BooksCloudDataSource.Base(service)
        val booksCacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())
        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())
        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())

        val booksRepository = BooksRepository.Base(
            booksCloudDataSource,
            booksCacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )

        val communication = BooksCommunication.Base()
        val booksInteractor = BooksInteractor.Base(booksRepository, BaseBooksDataToDomainMapper())
        mainViewModel =
            MainViewModel(
                booksInteractor,
                BaseBooksDomainToUiMapper(BooksCommunication.Base(), ResourceProvider.Base(this  )),
                communication
            )

    }
}