package com.ec.ardesign.ui.main.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ec.ardesign.data.UserRepository
import com.ec.ardesign.data.model.User
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val userRepository by lazy { UserRepository.newInstance(application) }

    val user = MutableLiveData<ViewState>()


    fun connexion(pseudo: String, pass: String) =
        viewModelScope.launch {
            user.value = ViewState.Loading
            try {
                user.value = ViewState.Content(user = userRepository.connexion(pseudo, pass))

            } catch (e: Exception) {
                user.value = ViewState.Error(e.message.orEmpty())
            }

        }


    sealed class ViewState {
        object Loading : ViewState()
        data class Content(val user: User) : ViewState()
        data class Error(val message: String) : ViewState()
    }
}