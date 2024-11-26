package edu.iesam.loginexam1eval.features.user.domain

import android.util.Log

class LogInUseCase(private val userRepository: UserRepository) {

    operator fun invoke(username: String, password:String): Boolean {

        val user = userRepository.findById(username)
        if (user == null){
            Log.d("@dev", "No se encuentra en el sistema, dese de alta antes")
            return false
        }else{
            return true
        }
        /* Estrcutura similar pero en Kotlin

        userRepository.findById(username)?.let {
        } ?: Log.d("@dev", "No se encuentra en el sistema, dese de alta antes")
        return true
         */

    }
}