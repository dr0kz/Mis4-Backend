package com.stojanche.krstevski.misbackend.web

import com.stojanche.krstevski.misbackend.service.AuthService
import com.stojanche.krstevski.misbackend.web.request.LoginRequest
import com.stojanche.krstevski.misbackend.web.request.RegisterRequest
import org.springframework.stereotype.Service

@Service
class AuthMapper(private val service: AuthService) {

    fun login(loginRequest: LoginRequest) = service.login(loginRequest)

    fun register(registerRequest: RegisterRequest) = service.register(registerRequest)

    fun logout() = service.logout()

}