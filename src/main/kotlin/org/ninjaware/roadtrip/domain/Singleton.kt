package org.ninjaware.roadtrip.domain

import java.util.*

object UUIDGenerator {

    fun next() = UUID.randomUUID().toString()
}