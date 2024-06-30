package com.example.instastories.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instastories.R
import com.example.instastories.data.db.entity.User
import com.example.instastories.ui.adapter.StoriesAdapter
import com.example.instastories.ui.viewmodel.UsersViewModel
import com.example.instastories.util.UserListConverter


class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UsersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialise recycler view to show all users with stories
        val recyclerView: RecyclerView = findViewById(R.id.rvUserStories)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Initialize view-model to store the data related to MainActivity
        userViewModel = ViewModelProvider(this)[UsersViewModel::class.java]

        // API call -> Get all users
        userViewModel.getUsers()
        userViewModel.userData.observe(this) {
            val customAdapter = StoriesAdapter(this, it)
            recyclerView.adapter = customAdapter
            customAdapter.onItemClick = { users: List<User>, pos: Int ->
                val userData = UserListConverter.fromStoryList(users)
                val fragment = StoryContainerFragment.newInstance(userData, pos)
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment).setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}