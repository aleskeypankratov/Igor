package ru.handh.school.igor.domain.model

import androidx.room.Entity
import ru.handh.school.igor.R

@Entity(tableName = "profile_info")
data class ProfileInfo(
    var surname: String,
    var name: String,
    val avatar: Int = R.drawable.base_avatar
)
