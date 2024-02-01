package com.example.cleancode.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleancode.presentation.posts_list.PostListScreen
import com.example.cleancode.presentation.ui.theme.CryptocurrencyAppYTTheme
import com.example.cleancode.presentation.users_list.UsersListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PostListScreen.route
                    ) {
                        composable(
                            route = Screen.PostListScreen.route
                        ) {
                            PostListScreen(navController)
                        }
                        composable(
                            route = Screen.UserListScreen.route/* + "/{id}"*/
                        ) {
                            UsersListScreen()
                        }
                    }
                }
            }
        }
    }
}