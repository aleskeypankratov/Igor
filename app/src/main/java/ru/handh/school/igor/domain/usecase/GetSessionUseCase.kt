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
    suspend fun getSession(code: String): ResultSignIn {
        return try {
            val response =
                repository.getSession(requireNotNull(keyValueStorage.deviceId), code, lifeTime)
            keyValueStorage.accessToken = response.data?.session?.accessToken
            keyValueStorage.refreshToken = response.data?.session?.refreshToken
            ResultSignIn.GotSession
        } catch (e: ClientRequestException) {
            ResultSignIn.InvalidCode
        } catch (e: ServerResponseException) {
            ResultSignIn.ServerError
        } catch (e: Exception) {
            ResultSignIn.UnknownError
        }
    }
}