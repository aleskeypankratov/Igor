package ru.handh.school.igor.domain.model.db

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
    var surname: String,
    var name: String
)

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile_info WHERE uid = 1")
    fun getProfile(): ProfileInfo
    @Insert
    fun insertProfile(profileInfo: ProfileInfo)
    @Query("DELETE FROM profile_info")
    fun deleteProfile()
}

@Database(entities = [ProfileInfo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
}
