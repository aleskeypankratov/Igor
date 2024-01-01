package ru.handh.school.igor.domain.usecase

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.ProfileInfo
import ru.handh.school.igor.domain.usecase.result.ResultProfile

class GetProfileUseCase(
    private val repository: IgorRepositoryImp, private val profileInfo: ProfileInfo
) {
    suspend fun getProfile(): ResultProfile<Unit> {
        return try {
            repository.getProfile()
            ResultProfile.GotProfile()
        } catch (e: ClientRequestException) {
            ResultProfile.RequestError()
        } catch (e: ServerResponseException) {
            ResultProfile.ServerError()
        } catch (e: Exception) {
            ResultProfile.UnknownError()
        }
    }
}