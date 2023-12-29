package ru.handh.school.igor.domain.model

import ru.handh.school.igor.R

data class ProfileInfo(
    var surname: String,
    var name: String,
    val avatar: Int = R.drawable.base_avatar
)
