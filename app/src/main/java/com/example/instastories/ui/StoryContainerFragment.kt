package com.example.instastories.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instastories.databinding.FragmentUserStoryBinding
import com.example.instastories.ui.adapter.UserStoriesAdapter
import com.example.instastories.util.UserListConverter

class StoryContainerFragment : Fragment() {

    private var _binding: FragmentUserStoryBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUserStoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userData = arguments?.getString("USERS")
        val pos = arguments?.getInt("POSITION")

        val userStoryAdapter = UserStoriesAdapter(
            UserListConverter.toStoryList(userData!!),
            requireFragmentManager(),
            lifecycle
        )
        binding.apply {
            vpUserStory.adapter = userStoryAdapter
            vpUserStory.offscreenPageLimit = 1
            vpUserStory.setPageTransformer { page, position ->
                page.pivotX = page.width.toFloat() * 0.5f
                page.pivotY = page.height.toFloat()
                page.rotation = -15.0f * position * -1.25f
            }
            pos?.let { vpUserStory.setCurrentItem(it, false) }
        }

    }

    companion object {
        fun newInstance(userList: String, pos: Int): StoryContainerFragment {
            val fragment = StoryContainerFragment()
            val bundle = Bundle()
            bundle.putString("USERS", userList)
            bundle.putInt("POSITION", pos)
            fragment.arguments = bundle
            return fragment
        }
    }

}