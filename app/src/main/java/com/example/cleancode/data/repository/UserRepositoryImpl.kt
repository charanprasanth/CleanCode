package com.example.cleancode.data.repository

import com.example.cleancode.data.remote.TypiCodeApi
import com.example.cleancode.data.remote.dto.PostDto
import com.example.cleancode.data.remote.dto.UserDto
import com.example.cleancode.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: TypiCodeApi
) : UserRepository {

    override suspend fun getUsers(): List<UserDto> {
        return api.getUsers()
    }

    override suspend fun getPosts(): List<PostDto> {
        return api.getPosts()
    }
}