package com.stojanche.krstevski.misbackend.service

import com.stojanche.krstevski.misbackend.domain.Event
import com.stojanche.krstevski.misbackend.repository.EventRepository
import com.stojanche.krstevski.misbackend.utils.UserUtils
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class EventService(
    private val repository: EventRepository,
    private val userEventService: UserEventService
) {

    fun findMyEventsGroupedByDateTime() = userEventService.findUserEvents()
        .groupBy { it.time }

    fun findMyUpcomingEvents() = userEventService.findMyUpcomingEvents()

    fun create(name: String, time: String): Event {
        val parseTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
        val user = UserUtils.getUser()
        val event = Event(0L, name, parseTime)
        val savedEvent = repository.save(event)
        userEventService.create(user, savedEvent)
        return event
    }

}