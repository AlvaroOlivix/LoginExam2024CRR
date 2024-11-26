package edu.iesam.loginexam1eval.features.user.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.features.user.domain.LogInUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LogInViewModel(
    private val logInUseCase: LogInUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    var uiState: LiveData<UiState> = _uiState

    fun logIn(username: String, password: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val response = logInUseCase.invoke(username, password)
            UiState(isSucess = true)
        }

    }

    data class UiState(
        val isSucess: Boolean = false
    )
}