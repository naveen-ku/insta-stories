package com.example.instastories.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.instastories.data.db.entity.User
import com.example.instastories.ui.StoryPlayerFragment
import com.example.instastories.util.UserListConverter

class UserStoriesAdapter(
    private val userList: List<User>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    // Returns the size of total users having stories
    override fun getItemCount(): Int =
        userList.size

    // Each StoryPlayerFragment will show all the stories related to particular user
    override fun createFragment(position: Int): Fragment {
        val user = UserListConverter.fromStory(userList[position])
        return StoryPlayerFragment.newInstance(user)
    }
}

