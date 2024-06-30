package com.example.instastories.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.instastories.data.db.entity.User
import com.example.instastories.data.repositories.UserRepository
import kotlinx.coroutines.launch

class UsersViewModel(application: Application) : AndroidViewModel(application) {

    var userData = MutableLiveData<List<User>>()
    private val context = getApplication<Application>().applicationContext

    fun getUsers() {
        viewModelScope.launch {
            try {
                // Inform the observer about data fetched successfully
                userData.postValue(UserRepository(context).getUsers())
                Log.d("Ninja", "ViewModel getUsers() success")
            } catch (error: Exception){
                Log.d("Ninja","ViewModel getUsers() exception $error")
            }

        }
    }
}