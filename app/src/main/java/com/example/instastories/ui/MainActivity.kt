package com.example.instastories.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instastories.R
import com.example.instastories.data.db.entity.User
import com.example.instastories.ui.adapter.StoriesAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rvUserStories);
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        userViewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        userViewModel.userData.observe(this) {
            val customAdapter = StoriesAdapter(this, it)
            recyclerView.adapter = customAdapter
            customAdapter.onItemClick = {
                val intent = Intent(this, StoryActivity::class.java)
//                val gson = Gson()
//                val type = object : TypeToken<List<User>>() {}.type
//                val str = gson.toJson(userViewModel.userData, type);
//                Log.d("Ninja str", str);
//                intent.putExtra("userData", str);
                startActivity(intent)
            }
        }


    }
}