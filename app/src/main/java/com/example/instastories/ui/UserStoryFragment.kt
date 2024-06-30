package com.example.instastories.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instastories.databinding.FragmentUserStoryBinding
import com.example.instastories.ui.adapter.UserStoryPagerAdapter
import com.example.instastories.util.UserListConverter

class UserStoryFragment : Fragment() {

    private var _binding: FragmentUserStoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUserStoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userData = arguments?.getString("USERS")
        val pos = arguments?.getInt("POSITION")

        val userStoryAdapter = UserStoryPagerAdapter(
            UserListConverter.toStoryList(userData!!),
            requireFragmentManager(),
            lifecycle
        )
        binding.vpUserStory.adapter = userStoryAdapter
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