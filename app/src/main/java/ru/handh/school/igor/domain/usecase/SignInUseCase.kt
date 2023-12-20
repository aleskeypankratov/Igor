package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.data.KeyValueStorage
import ru.handh.school.igor.domain.model.PostSignInRequest

class SignInUseCase(
    private val repository: IgorRepositoryImp,
    private val keyValueStorage: KeyValueStorage
) {
    suspend fun signIn(email: String): Result<Unit> {
        return try {
            repository.signIn(keyValueStorage.deviceId?: "", PostSignInRequest(email))
            Result.LoggedIn()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }
}