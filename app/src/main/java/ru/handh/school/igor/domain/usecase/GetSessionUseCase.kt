package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.usecase.UUID.uuid

class GetSessionUseCase(private val repository: IgorRepositoryImp) {

    private var lifeTime: Int = 300_000
    suspend fun getSession(code: String): Result<Unit> {
        return try {
            val response = repository.getSession(uuid, code, lifeTime)
            Result.GotSession()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }
}