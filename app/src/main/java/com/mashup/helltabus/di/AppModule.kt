package com.mashup.helltabus.di

import com.helltabus.data.api.DumApi
import com.helltabus.data.repository.UserDumRepositoryImpl
import com.helltabus.domain.repository.UserRepository
import com.helltabus.domain.usecase.GetUserUseCase
import com.mashup.helltabus.ExecutorProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Singleton
    @Provides
    fun provideExecutorProvider(): ExecutorProvider {
        return object : ExecutorProvider {
            override fun main(): CoroutineDispatcher {
                return Dispatchers.Main
            }
            
            override fun io(): CoroutineDispatcher {
                return Dispatchers.IO
            }
    
            override fun default(): CoroutineDispatcher {
                return Dispatchers.Default
            }
    
            override fun unconfined(): CoroutineDispatcher {
                return Dispatchers.Unconfined
            }
        }
    }
    
    @Provides
    fun provideGetUserUseCase(
        userRepository: UserRepository,
        executorProvider: ExecutorProvider
    ) : GetUserUseCase {
        return GetUserUseCase(userRepository, executorProvider.io())
    }

    @Provides
    fun provideUserRepository(api: DumApi): UserRepository {
        return UserDumRepositoryImpl(api)
    }

    // Logger 주입
    
    // 전역 Config
}
