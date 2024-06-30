package com.example.instastories.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instastories.data.repositories.UserRepository
import kotlinx.coroutines.launch

class UsersViewModel: ViewModel() {

    fun getUsers() {
        viewModelScope.launch {
            val users = UserRepository().getUsers();
            Log.d("Ninja ViewModel", users.toString());
        }
    }
}