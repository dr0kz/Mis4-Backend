package com.stojanche.krstevski.misbackend.web.request

data class RegisterRequest(
    val name: String,
    val surname: String,
    val email: String,
    val password: String
)
