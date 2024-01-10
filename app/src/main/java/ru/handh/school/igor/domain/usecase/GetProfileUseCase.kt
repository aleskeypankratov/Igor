package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.ProfileInfo
import ru.handh.school.igor.domain.usecase.result.ResultProfile

class GetProfileUseCase(private val repository: IgorRepositoryImp) {
    suspend fun getProfile(): ResultProfile<ProfileInfo> {
        return try {
            val profile = repository.getProfile()
            val profileInfo = ProfileInfo(
                profile.data?.profile?.surname?:"",
                profile.data?.profile?.name?:"")
            ResultProfile.GotProfile(profileInfo)
        } catch (e: Exception) {
            ResultProfile.UnknownError()
        }
    }
}