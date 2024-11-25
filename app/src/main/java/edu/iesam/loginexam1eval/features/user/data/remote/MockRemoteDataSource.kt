package edu.iesam.loginexam1eval.features.user.data.remote

import androidx.recyclerview.widget.ListAdapter
import edu.iesam.loginexam1eval.features.user.domain.User

class MockRemoteDataSource {

    private val users = listOf(
        User("UserName1", "1234"),
        User("UserName2", "123456"),
        User("UserName3", "12345678")
    )

    fun getUsers(): List<User> {
        return users
    }

    fun getUser(userId: String): User? {
        return users.firstOrNull()
    }
}