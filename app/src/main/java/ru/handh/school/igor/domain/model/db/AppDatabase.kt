package ru.handh.school.igor.domain.model.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProfileInfo::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
}
