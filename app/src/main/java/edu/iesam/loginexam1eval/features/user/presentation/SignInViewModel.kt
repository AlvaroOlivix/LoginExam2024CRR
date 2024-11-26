package edu.iesam.loginexam1eval.features.user.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.features.user.domain.SignInUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    var uiState: LiveData<UiState> = _uiState

    fun signIn(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = signInUseCase.invoke(username, password)
            UiState(isSucess = true)
        }


    }

    data class UiState(
        val isSucess: Boolean = false
    )
}