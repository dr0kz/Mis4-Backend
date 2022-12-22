package com.stojanche.krstevski.misbackend.api

import com.stojanche.krstevski.misbackend.web.AuthMapper
import com.stojanche.krstevski.misbackend.web.request.LoginRequest
import com.stojanche.krstevski.misbackend.web.request.RegisterRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auths")
class AuthController(private val mapper: AuthMapper) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest) = mapper.login(request)

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest) = mapper.register(request)

    @PostMapping("/logout")
    fun logout() = mapper.logout()

}