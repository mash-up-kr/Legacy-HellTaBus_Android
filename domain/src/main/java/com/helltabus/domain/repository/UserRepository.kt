/*
 * Created by Leo on 2021. 09. 26 ..
 */
package com.helltabus.domain.repository

import com.helltabus.domain.Result
import com.helltabus.domain.entity.User

interface UserRepository : Repository {
    suspend fun getUser(userId: Long): Result<User>
}
