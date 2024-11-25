package edu.iesam.loginexam1eval.features.user.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.features.user.domain.GetUsersUseCase
import edu.iesam.loginexam1eval.features.user.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated(){
        //****
        _uiState.value = (UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO){
            val users = getUsersUseCase.invoke()
            _uiState.postValue(UiState(users = users))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val users: List<User>? = null,
        //val error:ErrorApp? = null
    )
}