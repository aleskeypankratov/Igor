package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.PostSignInRequest
import ru.handh.school.igor.domain.usecase.UUID.uuid

class SignInUseCase(private val repository: IgorRepositoryImp) {
    suspend fun signIn(email: String): Result<Unit> {
        return try {
            repository.signIn(uuid, PostSignInRequest(email))
            Result.LoggedIn()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }
}