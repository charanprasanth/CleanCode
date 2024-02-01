package com.example.cleancode.presentation.users_list

import com.example.cleancode.domain.model.User

data class UsersListState( //default values can be null
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)
