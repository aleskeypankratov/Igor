package ru.handh.school.igor.domain.usecase

import java.util.UUID

object UUID {

    val uuid: String = UUID.randomUUID().toString()
    fun getUUID(): String {
        return uuid
    }
}