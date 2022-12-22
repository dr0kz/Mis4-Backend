package com.stojanche.krstevski.misbackend.api

import com.stojanche.krstevski.misbackend.web.EventMapper
import com.stojanche.krstevski.misbackend.web.request.EventRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/events")
class EventController(private val mapper: EventMapper) {

    @GetMapping("/my-events/grouped-by-date-time")
    fun findMyEventsGroupedByDateTime() = mapper.findMyEvents()

    @GetMapping("/my-upcoming-events")
    fun findMyUpcomingEvents() = mapper.findMyUpcomingEvents()

    @PostMapping
    fun create(@RequestBody request: EventRequest) = mapper.create(request)

}