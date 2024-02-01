package com.example.cleancode.presentation

sealed class Screen(val route: String) {
    data object PostListScreen: Screen("post_list_screen")
    data object UserListScreen: Screen("user_list_screen")
}