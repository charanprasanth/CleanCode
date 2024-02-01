package com.example.cleancode.data.remote.dto

import com.example.cleancode.domain.model.Post

data class PostDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun PostDto.toPost(): Post {
    return Post(
        body = body,
        id = id,
        title = title,
        userId = userId
    )
}