package com.example.cleancode.data.remote

import com.example.cleancode.data.remote.dto.PostDto
import com.example.cleancode.data.remote.dto.UserDto
import retrofit2.http.GET

interface TypiCodeApi {

    @GET("/posts")
    suspend fun getPosts(): List<PostDto>

    @GET("/users")
    suspend fun getUsers(): List<UserDto>
}