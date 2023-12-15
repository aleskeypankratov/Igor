package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.PostSignInRequest
import ru.handh.school.igor.domain.usecase.UUIDSingleton.uuid

class SignInUseCase(private val repository: IgorRepositoryImp) {
    // private val repository = IgorRepositoryImp()

    suspend fun signIn(email: String): Result<Unit> {
        return try {
            val response = repository.signIn(uuid, PostSignInRequest(email))
            Result.LoggedIn()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }
}