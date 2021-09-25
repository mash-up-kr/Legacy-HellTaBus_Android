/*
 * Created by Leo on 2021. 09. 26 ..
 */
package com.mashup.helltabus

import androidx.lifecycle.viewModelScope
import com.helltabus.domain.Result
import com.helltabus.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : BaseViewModel() {
    
    fun getUser() {
        viewModelScope.launch {
            try {
                val result =  getUserUseCase.invoke(0L)
                
                when (result) {
                    is Result.Error -> result.exception
                    Result.Loading -> {
                        /* explicitly empty */
                    }
                    is Result.Success -> {
                        val user = result.data
                        user.name
                    }
                }
            } catch (e: Exception) {
                /* explicitly empty */
            }
        }
    }
}
