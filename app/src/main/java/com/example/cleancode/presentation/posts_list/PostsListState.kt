package com.example.cleancode.presentation.posts_list

import com.example.cleancode.domain.model.Post

data class PostsListState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String = ""
)
