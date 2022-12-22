package com.stojanche.krstevski.misbackend.repository

import com.stojanche.krstevski.misbackend.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String): Optional<User>

}