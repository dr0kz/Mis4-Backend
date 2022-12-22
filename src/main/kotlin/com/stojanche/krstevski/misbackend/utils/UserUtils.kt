package com.stojanche.krstevski.misbackend.utils

import com.stojanche.krstevski.misbackend.domain.User
import org.springframework.security.core.context.SecurityContextHolder

class UserUtils {

    companion object {
        fun getUser(): User {
            return SecurityContextHolder.getContext().authentication.principal as User
        }
    }

}