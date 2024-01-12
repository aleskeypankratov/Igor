package ru.handh.school.igor.domain.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile_info WHERE uid = 1")
    fun getProfile(): ProfileInfo
    @Insert
    fun insertProfile(profileInfo: ProfileInfo)
    @Query("DELETE FROM profile_info")
    fun deleteProfile()
}