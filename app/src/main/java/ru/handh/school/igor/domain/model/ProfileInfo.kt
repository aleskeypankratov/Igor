package ru.handh.school.igor.domain.model

import kotlinx.serialization.Serializable
import ru.handh.school.igor.R

@Serializable
data class ProfileInfo(
    var surname: String,
    var name: String,
    val avatar: Int = R.drawable.base_avatar
)
