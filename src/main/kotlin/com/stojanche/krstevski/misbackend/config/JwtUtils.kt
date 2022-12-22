package com.stojanche.krstevski.misbackend.config

import org.springframework.security.core.Authentication
import com.stojanche.krstevski.misbackend.domain.User
import org.springframework.stereotype.Component
import java.util.*
import io.jsonwebtoken.*

@Component
class JwtUtils {

    private val jwtSecret: String = "dr0kz"

    private val jwtExpirationMs = 10 * 24 * 3600 * 1000 // 10 days

    fun generateJwtToken(authentication: Authentication): String {
        val userPrincipal = authentication.principal as User
        return Jwts.builder()
            .setSubject(userPrincipal.username)
            .setIssuedAt(Date())
            .setExpiration(Date(Date().time + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact()
    }

    fun getUserNameFromJwtToken(token: String?): String {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).body.subject
    }

    fun validateJwtToken(authToken: String?) = try {
        Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken)
        true
    } catch (ex: Exception) {
        false
    }

}