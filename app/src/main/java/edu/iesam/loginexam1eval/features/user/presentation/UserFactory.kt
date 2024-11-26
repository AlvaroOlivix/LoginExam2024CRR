package edu.iesam.loginexam1eval.features.user.presentation

import android.content.Context
import edu.iesam.loginexam1eval.features.user.data.UserDataRepository
import edu.iesam.loginexam1eval.features.user.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.features.user.domain.LogInUseCase
import edu.iesam.loginexam1eval.features.user.domain.SignInUseCase

class UserFactory(private val context: Context) {
    private val localDataSource = LoginXmlLocalDataSource(context)
    private val userDataRepository = UserDataRepository(localDataSource)
    private val signInUseCase = SignInUseCase(userDataRepository)
    private val logInUseCase = LogInUseCase(userDataRepository)

    fun buildSignInViewModel(): SignInViewModel {
        return SignInViewModel(signInUseCase)
    }

    fun buildLogInViewModel(): LogInViewModel {
        return LogInViewModel(logInUseCase)
    }
}