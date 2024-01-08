package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.usecase.result.ResultProfile

class GetProfileUseCase(
    private val repository: IgorRepositoryImp
) {
    suspend fun getProfile(): ResultProfile<Unit> {
        return try {
            repository.getProfile()
            ResultProfile.GotProfile()
        } catch (e: Exception) {
            ResultProfile.UnknownError()
        }
    }
}