package ru.handh.school.igor.domain.usecase

import android.util.Log
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.data.KeyValueStorage

class SignOutUseCase(
    private val repository: IgorRepositoryImp,
    private val keyValueStorage: KeyValueStorage
) {
    suspend fun signOut(): Result<Unit> {
        return try {
            keyValueStorage.refreshToken = null
            keyValueStorage.accessToken = null
            Log.v("token", "${keyValueStorage.refreshToken} ${keyValueStorage.accessToken}")
            repository.signOut()
            Result.Default()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }
}