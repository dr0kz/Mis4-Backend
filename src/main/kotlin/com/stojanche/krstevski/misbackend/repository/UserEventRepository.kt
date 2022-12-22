package com.stojanche.krstevski.misbackend.repository

import com.stojanche.krstevski.misbackend.domain.UserEvent
import org.springframework.data.jpa.repository.JpaRepository

interface UserEventRepository: JpaRepository<UserEvent, Long> {

    fun findAllByUserId(id: Long): List<UserEvent>

}