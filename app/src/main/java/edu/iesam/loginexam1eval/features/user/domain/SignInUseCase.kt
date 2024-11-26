package edu.iesam.loginexam1eval.features.user.domain

class SignInUseCase(private val userRepository: UserRepository) {

    operator fun invoke(username: String, password: String): Boolean {
        /* Ejemplo del mismo desarrollo pero en Java

        val user:User? = userRepository.findById(username)
          if(user == null){
             userRepository.save(User(username, username. password)
        }

        */
        userRepository.findById(username)?.let {
        } ?: userRepository.save(User(username, username, password))
        return true
    }

}