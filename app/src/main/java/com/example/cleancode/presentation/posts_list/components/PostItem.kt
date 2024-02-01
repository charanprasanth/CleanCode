package com.example.cleancode.presentation.posts_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cleancode.domain.model.Post

@Composable
fun PostItem(
    post: Post,
    onItemClick: (Post) -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onItemClick(post) }
            .padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = post.title)
        Text(text = post.body)
    }
}