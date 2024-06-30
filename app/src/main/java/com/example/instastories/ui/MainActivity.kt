package com.example.instastories.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instastories.R

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var userViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvUserStories);
        recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        Log.d("Ninja MainActivity ",userViewModel.getUsers().toString())

    }
}