package edu.iesam.loginexam1eval.features.user.domain

class GetUserUseCase(private val userRepository: UserRepository) {
    operator fun invoke(userId: String): User? {
        return userRepository.getUser(userId)
    }
}