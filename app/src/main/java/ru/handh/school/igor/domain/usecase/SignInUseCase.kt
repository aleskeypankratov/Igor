package ru.handh.school.igor.domain.usecase

import io.ktor.http.HttpStatusCode
import ru.handh.school.igor.data.IgorRepository
import ru.handh.school.igor.domain.model.PostSignInRequest
import java.util.UUID

class SignInUseCase(private val repository: IgorRepository) {
    suspend fun signIn(email: String): HttpStatusCode {
        return repository.signIn(getDeviceUUID(), PostSignInRequest(email))
    }
    private fun getDeviceUUID():String {
        return UUID.randomUUID().toString()
    }
}