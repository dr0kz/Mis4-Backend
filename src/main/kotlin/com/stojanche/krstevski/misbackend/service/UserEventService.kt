package com.stojanche.krstevski.misbackend.service

import com.stojanche.krstevski.misbackend.domain.Event
import com.stojanche.krstevski.misbackend.domain.User
import com.stojanche.krstevski.misbackend.domain.UserEvent
import com.stojanche.krstevski.misbackend.repository.UserEventRepository
import com.stojanche.krstevski.misbackend.utils.UserUtils
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserEventService(private val repository: UserEventRepository) {

    fun findUserEvents(): List<Event> {
        val user = UserUtils.getUser()
        return repository.findAllByUserId(user.id).map { it.event }
    }

    fun findMyUpcomingEvents(): List<Event> {
        val user = UserUtils.getUser()
        return repository.findAllByUserId(user.id).filter {
            it.event.time.isAfter(LocalDateTime.now())
        }.map { it.event }
    }

    fun create(user: User, event: Event): UserEvent {
        val userEvent = UserEvent(0L, user, event)
        return repository.save(userEvent)
    }
}