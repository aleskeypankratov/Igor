package ru.handh.school.igor.domain.usecase

import android.util.Patterns
import io.ktor.client.plugins.ServerResponseException
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.data.KeyValueStorage
import ru.handh.school.igor.domain.model.PostSignInRequest
import ru.handh.school.igor.domain.usecase.result.ResultSignIn

class SignInUseCase(
    private val repository: IgorRepositoryImp,
    private val keyValueStorage: KeyValueStorage
) {
    suspend fun signIn(email: String): ResultSignIn {
        return try {
            if (isEmailValid(email)) {
                repository.signIn(requireNotNull(keyValueStorage.deviceId), PostSignInRequest(email))
                ResultSignIn.LoggedIn
            } else {
                ResultSignIn.InvalidEmail
            }
        } catch (e: ServerResponseException) {
            ResultSignIn.ServerError
        } catch (e: Exception) {
            ResultSignIn.UnknownError
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}