package edu.iesam.loginexam1eval.features.user.domain

class GetUsersUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): List<User> {
        return userRepository.getUsers()
    }
}