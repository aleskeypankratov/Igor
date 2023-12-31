package ru.handh.school.igor.domain.usecase

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.usecase.result.ResultProject

class GetProjectUseCase(
    private val repository: IgorRepositoryImp
) {
    suspend fun getProject(): ResultProject<Unit> {
        return try {
            val response = repository.getProjects()
            ResultProject.GotProject()
        } catch (e: ClientRequestException) {
            ResultProject.RequestError()
        } catch (e: ServerResponseException) {
            ResultProject.ServerError()
        } catch (e: Exception) {
            ResultProject.UnknownError()
        }
    }
}