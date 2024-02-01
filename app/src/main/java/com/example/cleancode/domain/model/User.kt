package com.example.cleancode.domain.model

import com.example.cleancode.data.remote.dto.Address
import com.example.cleancode.data.remote.dto.Company

data class User(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String
)
