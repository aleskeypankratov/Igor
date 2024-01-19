package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.db.ProfileInfo
import ru.handh.school.igor.domain.usecase.result.ResultProfile

class GetProfileUseCase(private val repository: IgorRepositoryImp) {
    suspend fun getProfile(): ResultProfile {
        return try {
            val profile = repository.getProfile()
            ResultProfile.GotProfile(
                ProfileInfo(
                    surname = requireNotNull(profile.data?.profile?.surname),
                    name = requireNotNull(profile.data?.profile?.name)
                )
            )
        } catch (e: Exception) {
            ResultProfile.UnknownError
        }
    }
}