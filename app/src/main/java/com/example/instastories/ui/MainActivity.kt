package com.example.instastories.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instastories.R
import com.example.instastories.ui.adapter.StoriesAdapter

class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView :RecyclerView = findViewById(R.id.rvUserStories);
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        userViewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        Log.d("Ninja MainActivity ",userViewModel.getUsers().toString())
        userViewModel.userData.observe(this){
            val customAdapter = StoriesAdapter(this, it)
            recyclerView.adapter = customAdapter
        }


    }
}