package com.example.cleancode.presentation.users_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cleancode.domain.model.Post
import com.example.cleancode.domain.model.User

@Composable
fun UserItem(user: User) {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = user.name)
        Text(text = user.email)
    }
}