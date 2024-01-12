package ru.handh.school.igor.domain.model.db

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "profile_info")
data class ProfileInfo(
    @PrimaryKey val uid: Int = 1,
    @ColumnInfo var surname: String?,
    @ColumnInfo var name: String?
)



