package com.example.cleancode.presentation.users_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleancode.common.Resource
import com.example.cleancode.domain.use_case.get_users.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(UsersListState())
    val state: State<UsersListState> = _state

    init {
        getUsers()
    }

    private fun getUsers() {
        getUsersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UsersListState(users = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = UsersListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = UsersListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}