package ru.handh.school.igor.domain.usecase

import android.util.Log
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.db.ProfileInfo
import ru.handh.school.igor.domain.usecase.result.ResultProfile

class GetProfileUseCase(private val repository: IgorRepositoryImp) {
    suspend fun getProfile(): ResultProfile {
        return try {
            val profile = repository.getProfile()
            Log.v("profile",profile.toString())
            ResultProfile.GotProfile(ProfileInfo(
                uid = 1,
                surname = profile.data?.profile?.surname!!,
                name = profile.data?.profile?.name!!
            ))
        } catch (e: Exception) {
            ResultProfile.UnknownError
        }
    }
}