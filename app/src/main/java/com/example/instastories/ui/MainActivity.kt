package com.example.instastories.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instastories.R
import com.example.instastories.data.db.entity.User
import com.example.instastories.ui.adapter.StoriesAdapter
import com.example.instastories.util.UserListConverter


class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rvUserStories);
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        userViewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        userViewModel.getUsers()
        userViewModel.userData.observe(this) {
            val customAdapter = StoriesAdapter(this, it)
            recyclerView.adapter = customAdapter
            customAdapter.onItemClick = { users: List<User>, pos: Int ->
                val userData = UserListConverter.fromStoryList(users)
                val fragment = UserStoryFragment.newInstance(userData,pos);
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
            }
        }
    }
}