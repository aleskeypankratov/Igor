package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.PostSignInRequest
import java.util.UUID

class SignInUseCase() {
    private val repository = IgorRepositoryImp()

    suspend fun signIn(email: String): Result<Unit> {
        return try {
            repository.signIn(getDeviceUUID(), PostSignInRequest(email))
            Result.Login()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }

    private fun getDeviceUUID(): String {
        return UUID.randomUUID().toString()
    }
}