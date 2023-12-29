package ru.handh.school.igor.domain.usecase

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.http.HttpStatusCode
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.ProfileInfo
import ru.handh.school.igor.domain.usecase.result.ResultProfile

class GetProfileUseCase(private val repository: IgorRepositoryImp, private val profileInfo: ProfileInfo) {
    suspend fun getProfile(): ResultProfile<Unit> {
        return try {
            val response = repository.getProfile()
            profileInfo.surname = response.data.profile.surname
            profileInfo.name = response.data.profile.name
            ResultProfile.GotProfile()
        } catch (e: ClientRequestException) {
            if (e.response.status == HttpStatusCode.Unauthorized) {
                repository.refresh()
                repository.getProfile()
                ResultProfile.GotProfile()
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