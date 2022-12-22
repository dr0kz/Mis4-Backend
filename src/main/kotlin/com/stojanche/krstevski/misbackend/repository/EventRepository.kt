package com.stojanche.krstevski.misbackend.repository

import com.stojanche.krstevski.misbackend.domain.Event
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<Event, Long>