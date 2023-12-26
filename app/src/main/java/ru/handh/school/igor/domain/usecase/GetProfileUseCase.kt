package ru.handh.school.igor.domain.usecase

import io.ktor.client.plugins.ServerResponseException
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.usecase.result.ResultProfile

class GetProfileUseCase(private val repository: IgorRepositoryImp) {
    suspend fun getProfile(): ResultProfile<Unit> {
        return try {
            repository.getProfile()
            ResultProfile.LogOut()
        } catch (e: ServerResponseException) {
            ResultProfile.ServerError()
        } catch (e: Exception) {
            ResultProfile.UnknownError()
        }
    }
}