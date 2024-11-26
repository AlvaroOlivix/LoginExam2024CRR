package edu.iesam.loginexam1eval.features.user.data

import edu.iesam.loginexam1eval.features.user.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.features.user.domain.User
import edu.iesam.loginexam1eval.features.user.domain.UserRepository

class UserDataRepository(
    private val localDataSource: LoginXmlLocalDataSource
) : UserRepository {

    override fun findById(username: String): User? {
        return localDataSource.findById(username)
    }

    override fun save(user: User) {
        return localDataSource.save(user)

    }

}