package ru.handh.school.igor.domain.model

import kotlinx.serialization.Serializable
import ru.handh.school.igor.R

@Serializable
data class ProfileInfo(
    val surname: String,
    val name: String,
    val avatar: Int = R.drawable.base_avatar
)
