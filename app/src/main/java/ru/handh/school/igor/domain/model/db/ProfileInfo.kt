package ru.handh.school.igor.domain.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_info")
data class ProfileInfo(
    @PrimaryKey val uid: Int = 1,
    @ColumnInfo(name  = "surname") var surname: String?,
    @ColumnInfo(name  = "name") var name: String?
)



