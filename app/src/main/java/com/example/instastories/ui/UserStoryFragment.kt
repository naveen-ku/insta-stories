package com.example.instastories.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instastories.R

class UserStoryFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val userData = arguments?.getString("USERS")
        val pos = arguments?.getInt("POSITION")
        return inflater.inflate(R.layout.fragment_user_story, container, false)
    }

    companion object {
        fun newInstance(userList: String, pos: Int): UserStoryFragment {
            val fragment = UserStoryFragment()
            val bundle = Bundle()
            bundle.putString("USERS", userList)
            bundle.putInt("POSITION", pos)
            fragment.arguments = bundle
            return fragment
        }
    }

}