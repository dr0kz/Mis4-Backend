package com.stojanche.krstevski.misbackend.web

import com.stojanche.krstevski.misbackend.service.EventService
import com.stojanche.krstevski.misbackend.web.request.EventRequest
import org.springframework.stereotype.Service

@Service
class EventMapper(private val service: EventService) {

    fun findMyEvents() = service.findMyEventsGroupedByDateTime()

    fun findMyUpcomingEvents() = service.findMyUpcomingEvents()

    fun create(request: EventRequest) = with(request) {
        service.create(name, time)
    }

}