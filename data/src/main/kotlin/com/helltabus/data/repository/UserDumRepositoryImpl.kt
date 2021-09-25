package com.helltabus.data.repository

import com.helltabus.data.api.DumApi
import com.helltabus.data.request.Daangn
import com.helltabus.domain.Result
import com.helltabus.domain.entity.User
import com.helltabus.domain.repository.UserRepository

class UserDumRepositoryImpl(
    private val dumApi: DumApi
) : UserRepository {
    override suspend fun getUser(userId: Long): Result<User> {
        return try {
            val user = dumApi.getDumUser(userId.toString()).data
            if (user != null) {
                Result.Success(
                    user.toEntity()
                )
            } else {
                Result.Error(Exception("eeee"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun postUser(userId: Long): Result<User> {
        return try {
            val user = dumApi.postDumUser(Daangn(userId).invoke()).data
            if (user != null) {
                Result.Success(
                    user.toEntity()
                )
            } else {
                Result.Error(Exception("eeee"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
