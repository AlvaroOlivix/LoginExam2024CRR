package edu.iesam.loginexam1eval.features.user.presentation

import android.content.Context
import edu.iesam.loginexam1eval.features.user.data.UserDataRepository
import edu.iesam.loginexam1eval.features.user.data.local.LoginXmlLocalDataSource

class UserFactory(private val  context: Context) {
    private val localDataSource = LoginXmlLocalDataSource(context)
    private val remoteDataSource = MockRemoteDataSource()
    private val userDataRepository = UserDataRepository(localDataSource, remoteDataSource)
    private val getUserUseCase = GetUserUseCase(userDataRepository)
    private val getUsersUseCase = GetUsersUseCase(userDataRepository)

    fun buildUsersViewModel(): UsersViewModel {
        return UsersViewModel(getUsersUseCase)
    }

    fun buildUserViewModel(): UserViewModel {
        return UserViewModel(getUserUseCase)
    }
}