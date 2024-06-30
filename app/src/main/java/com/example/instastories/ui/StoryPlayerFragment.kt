package com.example.instastories.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.instastories.data.db.entity.User
import com.example.instastories.databinding.FragmentStoryPlayerBinding
import com.example.instastories.util.UserListConverter
import jp.shts.android.storiesprogressview.StoriesProgressView


class StoryPlayerFragment : Fragment(), StoriesProgressView.StoriesListener {

    private var _binding: FragmentStoryPlayerBinding? = null
    private val binding get() = _binding!!

    private lateinit var userData: User
    private lateinit var storiesProgressView: StoriesProgressView
    private var counter = 0
    var pressTime = 0L
    var limit = 500L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStoryPlayerBinding.inflate(inflater, container, false)

        userData = UserListConverter.toStory(arguments?.getString("USER")!!)
        Log.d("Ninja StoryPlayerFragment", userData.toString())
        storiesProgressView = binding.stories
        storiesProgressView.setStoriesCount(userData.stories.size)
        storiesProgressView.setStoryDuration(5000L);
        storiesProgressView.setStoriesListener(this);
        // below line is use to start stories progress bar.
        storiesProgressView.startStories(counter);

        binding.vReverse.setOnClickListener { storiesProgressView.reverse() }
        binding.vSkip.setOnClickListener { storiesProgressView.skip() }

        Glide.with(requireContext()).load(userData.profileImageUrl).circleCrop()
            .into(binding.ivUserImage);
        binding.tvStoryUserName.text = userData.username

        addStoryData(userData.stories[counter].imageUrl)

        return binding.root
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

    override fun onNext() {
        addStoryData(userData.stories[++counter].imageUrl)

    }

    override fun onPrev() {
        if ((counter - 1) < 0) return;
        addStoryData(userData.stories[--counter].imageUrl)
    }

    override fun onComplete() {
        activity?.onBackPressed()
    }

    fun addStoryData(url: String) {
        Glide.with(requireContext()).load(url).diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(binding.ivStoryImage);
    }
}