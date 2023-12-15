package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.usecase.UUIDSingleton.uuid

class GetSessionUseCase(private val repository: IgorRepositoryImp) {
    suspend fun getSession(code: String): Result<Unit> {
        return try {
            val response = repository.getSession(uuid, code, 300_000)
            Result.GotSession()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }
}