package ru.handh.school.igor.domain.usecase

import io.ktor.http.HttpStatusCode
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.PostSignInRequest
import java.util.UUID

class SignInUseCase() {

    private val repository = IgorRepositoryImp()
    suspend fun signIn(email: String): Boolean {
        return repository.signIn(getDeviceUUID(), PostSignInRequest(email)) == HttpStatusCode.OK
    }

    private fun getDeviceUUID(): String {
        return UUID.randomUUID().toString()
    }
}