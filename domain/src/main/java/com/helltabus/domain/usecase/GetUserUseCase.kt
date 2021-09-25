/*
 * Created by Leo on 2021. 09. 26 ..
 */
package com.helltabus.domain.usecase

import com.helltabus.domain.Result
import com.helltabus.domain.entity.User
import com.helltabus.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher

class GetUserUseCase(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher
) : ParameterizedUseCase<Long, User>(dispatcher) {
    
    override suspend fun execute(userId: Long): Result<User> {
        return userRepository.getUser(userId)
    }
}
