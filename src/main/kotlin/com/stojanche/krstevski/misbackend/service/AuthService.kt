package com.stojanche.krstevski.misbackend.service

import com.stojanche.krstevski.misbackend.config.JwtUtils
import org.springframework.security.crypto.password.PasswordEncoder
import com.stojanche.krstevski.misbackend.domain.User
import com.stojanche.krstevski.misbackend.repository.UserRepository
import com.stojanche.krstevski.misbackend.web.request.LoginRequest
import com.stojanche.krstevski.misbackend.web.request.RegisterRequest
import com.stojanche.krstevski.misbackend.web.response.LoginResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val jwtUtils: JwtUtils,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val authenticationManager: AuthenticationManager,
) {

    fun login(loginRequest: LoginRequest): LoginResponse {
        val authentication: Authentication = try {
            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(loginRequest.email, loginRequest.password)
            )
        } catch (ex: Exception) {
            throw RuntimeException("Невалидна емаил адреса или лозинка.")
        }
        SecurityContextHolder.getContext().authentication = authentication
        val jwt = jwtUtils.generateJwtToken(authentication)
        return LoginResponse(jwt)
    }

    fun register(registerRequest: RegisterRequest) = with(registerRequest) {
        if (userRepository.findByEmail(email).isPresent) {
            throw RuntimeException("Корисникот веќе постои")
        }

        val user = User(0L, name, surname, email, passwordEncoder.encode(password))

        userRepository.save(user)

    }

    fun logout() = SecurityContextHolder.clearContext()

}