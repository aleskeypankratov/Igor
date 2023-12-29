package ru.handh.school.igor.domain.usecase

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.http.HttpStatusCode
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.data.KeyValueStorage
import ru.handh.school.igor.domain.usecase.result.ResultProfile

class SignOutUseCase(
    private val repository: IgorRepositoryImp, private val keyValueStorage: KeyValueStorage
) {
    suspend fun signOut(): ResultProfile<Unit> {
        return try {
            val response = repository.signOut()
            if (response.equals(ResultProfile.LogOut<Unit>())) {
                keyValueStorage.refreshToken = null
                keyValueStorage.accessToken = null
            }
            //Log.v("token", "${keyValueStorage.refreshToken} ${keyValueStorage.accessToken}")
            ResultProfile.LogOut()
        } catch (e: ClientRequestException) {
            if (e.response.status == HttpStatusCode.Unauthorized) {
                repository.refresh()
                repository.signOut()
                ResultProfile.LogOut()
            } else {
                ResultProfile.RequestError()
            }
        } catch (e: ServerResponseException) {
            ResultProfile.ServerError()
        } catch (e: Exception) {
            ResultProfile.UnknownError()
        }
    }
}