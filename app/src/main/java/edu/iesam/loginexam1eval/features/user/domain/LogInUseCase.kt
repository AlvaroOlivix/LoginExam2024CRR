package edu.iesam.loginexam1eval.features.user.domain

import android.util.Log

class LogInUseCase(private val userRepository: UserRepository) {

    operator fun invoke(username: String, password: String): Boolean {
        val user = userRepository.findById(username)
        return if (user == null) {
            val newUser = userRepository.save(User(username, username, password))
            //Usuario no existente creado
            true
        } else {
            //Usuario existente, no hace nada
            false
        }
        /* Estrcutura similar pero en Kotlin

        userRepository.findById(username)?.let {
        }
        return true
         */
    }
}