package ru.handh.school.igor.domain.model.db

import android.app.Application
import androidx.room.Room

fun providesDatabase(application: Application):AppDatabase =
    Room.databaseBuilder(application,AppDatabase::class.java,"profile_info")
        .build()

