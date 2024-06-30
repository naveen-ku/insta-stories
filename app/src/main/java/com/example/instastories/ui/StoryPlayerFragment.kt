package com.example.instastories.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instastories.R
import com.example.instastories.data.db.entity.User
import com.example.instastories.util.UserListConverter

class StoryPlayerFragment : Fragment() {

    private lateinit var userData: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        userData = UserListConverter.toStory(arguments?.getString("USER")!!)
        Log.d("Ninja StoryPlayerFragment", userData.toString())
        return inflater.inflate(R.layout.fragment_story_player, container, false)
    }

    companion object {
        private const val USER = "USER"
        fun newInstance(user: String): StoryPlayerFragment {
            val fragment = StoryPlayerFragment()
            val bundle = Bundle()
            bundle.putString("USER", user)
            fragment.arguments = bundle
            return fragment;
        }
    }
}