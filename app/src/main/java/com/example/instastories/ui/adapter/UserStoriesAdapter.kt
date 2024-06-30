package com.example.instastories.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.instastories.data.db.entity.User
import com.example.instastories.ui.StoryPlayerFragment
import com.example.instastories.util.UserListConverter

class UserStoriesAdapter(
    private val UserList: List<User>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int =
        UserList.size

    override fun createFragment(position: Int): Fragment {
        val user = UserListConverter.fromStory(UserList[position])
        return StoryPlayerFragment.newInstance(user)
    }
}

