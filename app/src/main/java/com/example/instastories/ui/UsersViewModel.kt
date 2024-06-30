package com.example.instastories.ui

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
            userData.value = UserRepository().getUsers();
            Log.d("Ninja ViewModel", userData.toString());
        }
    }
}