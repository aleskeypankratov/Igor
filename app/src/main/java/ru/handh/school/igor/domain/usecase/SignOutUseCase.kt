package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.data.KeyValueStorage

class SignOutUseCase(
    private val repository: IgorRepositoryImp,
    private val keyValueStorage: KeyValueStorage
) {
    suspend fun signOut(): Result<Unit> {
        return try {
            repository.signOut()
            keyValueStorage.refreshToken = null
            keyValueStorage.accessToken = null
            Result.Default()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }
}