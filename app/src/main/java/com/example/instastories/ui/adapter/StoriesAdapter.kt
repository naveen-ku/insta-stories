package com.example.instastories.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instastories.R
import com.example.instastories.data.db.entity.Story
import com.example.instastories.data.db.entity.User

class StoriesAdapter(
    private val context: Context,
    private val userData: List<User>,
) :
    RecyclerView.Adapter<StoriesAdapter.ViewHolder>() {

    var onItemClick: ((List<User>, position: Int) -> Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var userName: TextView
        val userImage: ImageView

        init {
            userName = view.findViewById(R.id.tvUserName)
            userImage = view.findViewById(R.id.ivUserImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.story_item, parent, false))
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userName.text = userData[position].username
        Glide.with(context).load(userData[position].profileImageUrl).circleCrop()
            .into(holder.userImage);
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(userData, position)
        }
    }

}