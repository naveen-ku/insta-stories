package com.example.instastories.ui

import android.net.http.NetworkException
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instastories.data.db.entity.User
import com.example.instastories.data.repositories.UserRepository
import kotlinx.coroutines.launch

class UsersViewModel: ViewModel() {

    var userData = MutableLiveData<List<User>>()

    fun getUsers() {
        viewModelScope.launch {
            try {
                userData.value = UserRepository().getUsers();
                Log.d("Ninja", "ViewModel getUsers() success")
            } catch (error: Exception){
                Log.d("Ninja","ViewModel getUsers() exception ${error}")
            }

        }
    }
}