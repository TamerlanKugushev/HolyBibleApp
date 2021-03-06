package com.example.holybibleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.holybibleapp.core.BibleApp
import com.example.holybibleapp.presentation.BibleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as BibleApp).mainViewModel
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val bibleAdapter = BibleAdapter()
        recyclerView.adapter = bibleAdapter

        viewModel.observe(this,{
            bibleAdapter.update(it)
        })
        viewModel.fetchBooks()
    }
}