package ru.handh.school.igor.domain.usecase

import io.ktor.client.plugins.ServerResponseException
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.data.KeyValueStorage
import ru.handh.school.igor.domain.usecase.result.ResultProfile

class SignOutUseCase(
    private val repository: IgorRepositoryImp, private val keyValueStorage: KeyValueStorage
) {
    suspend fun signOut(): ResultProfile<Unit> {
        return try {
            repository.signOut()
            keyValueStorage.refreshToken = null
            keyValueStorage.accessToken = null
            ResultProfile.LogOut()
        } catch (e: ServerResponseException) {
            ResultProfile.ServerError()
        } catch (e: Exception) {
            ResultProfile.UnknownError()
        }
    }
}