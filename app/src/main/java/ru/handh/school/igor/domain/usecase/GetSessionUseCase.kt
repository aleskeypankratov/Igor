package ru.handh.school.igor.domain.usecase

import android.util.Log
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.data.KeyValueStorage

class GetSessionUseCase(
    private val repository: IgorRepositoryImp,
    private val keyValueStorage: KeyValueStorage
) {

    private var lifeTime: Int = 300_000
    suspend fun getSession(code: String): Result<Unit> {
        return try {
            val response = repository.getSession(keyValueStorage.deviceId!!, code, lifeTime)
            keyValueStorage.accessToken = response.data.session.accessToken
            keyValueStorage.refreshToken = response.data.session.refreshToken
            Log.v("token", "${keyValueStorage.accessToken} ${keyValueStorage.refreshToken}")
            Result.GotSession()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }
}