package com.example.cleancode.domain.repository

import com.example.cleancode.data.remote.dto.PostDto
import com.example.cleancode.data.remote.dto.UserDto

interface UserRepository {

    suspend fun getUsers(): List<UserDto>

    suspend fun getPosts(): List<PostDto>
}