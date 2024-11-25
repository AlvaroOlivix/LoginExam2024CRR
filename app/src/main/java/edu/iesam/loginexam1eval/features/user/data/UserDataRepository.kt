package edu.iesam.loginexam1eval.features.user.data

import edu.iesam.loginexam1eval.features.user.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.features.user.data.remote.MockRemoteDataSource
import edu.iesam.loginexam1eval.features.user.domain.User
import edu.iesam.loginexam1eval.features.user.domain.UserRepository

class UserDataRepository(
    private val localDataSource: LoginXmlLocalDataSource,
    private val remoteDataSource: MockRemoteDataSource
) : UserRepository {
    override fun getUsers(): List<User> {
        val usersLocal = localDataSource.findAll()
        if (usersLocal.isEmpty()) {
            val usersRemote = remoteDataSource.getUsers()
            localDataSource.saveAll(usersRemote)
        } else {
            return usersLocal
        }
        return usersLocal
    }

    override fun getUser(userId: String): User? {
        val userLocal = localDataSource.findById(userId)
        if (userLocal == null) {
            //****
            remoteDataSource.getUser(userId)?.let {
                localDataSource.save(it)
                return it
            }
        }
        return userLocal
    }
}