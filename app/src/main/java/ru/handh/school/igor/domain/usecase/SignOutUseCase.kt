package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp

class SignOutUseCase(
    private val repository: IgorRepositoryImp
) {
    suspend fun signOut(): Result<Unit> {
        return try {
            repository.signOut()
            Result.Default()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }
}