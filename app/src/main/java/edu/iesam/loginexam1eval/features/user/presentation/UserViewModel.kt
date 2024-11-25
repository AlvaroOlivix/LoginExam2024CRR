package edu.iesam.loginexam1eval.features.user.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.features.user.domain.GetUserUseCase
import edu.iesam.loginexam1eval.features.user.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uistate: LiveData<UiState> = _uiState

    fun viewCreated(userId: String) {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(userId)
            _uiState.postValue(UiState(user = user))
        }
    }


    data class UiState(
        val isLoading: Boolean = false,
        val user: User? = null
        //val error=ErrorApp?=null
    )
}