package edu.iesam.loginexam1eval.features.user.domain

interface UserRepository {

    fun getUsers():List<User>
    fun getUser(userId: String):User?
}