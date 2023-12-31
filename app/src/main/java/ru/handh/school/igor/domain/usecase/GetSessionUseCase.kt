package ru.handh.school.igor.domain.usecase

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.data.KeyValueStorage
import ru.handh.school.igor.domain.usecase.result.ResultSignIn

class GetSessionUseCase(
    private val repository: IgorRepositoryImp,
    private val keyValueStorage: KeyValueStorage
) {

    private var lifeTime: Int = 300_000
    suspend fun getSession(code: String): ResultSignIn<Unit> {
        return try {
            val response = repository.getSession(keyValueStorage.deviceId ?: "", code, lifeTime)
            keyValueStorage.accessToken = response.data?.session?.accessToken
            keyValueStorage.refreshToken = response.data?.session?.refreshToken
            //Log.v("token", "${keyValueStorage.accessToken} ${keyValueStorage.refreshToken}")
            ResultSignIn.GotSession()
        } catch (e: ClientRequestException) {
            ResultSignIn.RequestError()
        } catch (e: ServerResponseException) {
            ResultSignIn.RequestError()
        } catch (e: Exception) {
            ResultSignIn.UnknownError()
        }
    }
}