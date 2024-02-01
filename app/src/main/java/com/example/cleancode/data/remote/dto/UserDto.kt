package com.example.cleancode.data.remote.dto

import com.example.cleancode.domain.model.User

data class UserDto(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)

fun UserDto.toUser(): User {
    return User (
        address = address,
        company= company,
        email = email,
        id = id,
        name = name,
        phone = phone
    )
}