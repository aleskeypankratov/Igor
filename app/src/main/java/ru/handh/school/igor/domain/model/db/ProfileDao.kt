package ru.handh.school.igor.domain.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile_info WHERE uid = 1")
    suspend fun getProfile(): ProfileInfo?

    @Insert
    suspend fun insertProfile(profileInfo: ProfileInfo)

    @Query("DELETE FROM profile_info WHERE uid = 1")
    suspend fun deleteProfile()
}