package ru.handh.school.igor.domain.usecase

import java.util.UUID

object UUIDSingleton {
    val uuid: String = UUID.randomUUID().toString()

    fun getUUID(): String {
        return uuid
    }
}