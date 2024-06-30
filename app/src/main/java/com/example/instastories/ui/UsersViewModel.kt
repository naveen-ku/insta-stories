package com.example.instastories.ui

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
                userData.postValue(UserRepository(context).getUsers())
//                userData.value = UserRepository().getUsers();
                Log.d("Ninja", "ViewModel getUsers() success")
            } catch (error: Exception){
                Log.d("Ninja","ViewModel getUsers() exception ${error}")
            }

        }
    }
}