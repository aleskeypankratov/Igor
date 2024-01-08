package ru.handh.school.igor.domain.usecase

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.getProjectsResponse.GetProjectsResponse
import ru.handh.school.igor.domain.usecase.result.ResultProject

class GetProjectUseCase(
    private val repository: IgorRepositoryImp
) {
    suspend fun getProject(): ResultProject<GetProjectsResponse> {
        return try {
            val response = repository.getProjects()
            ResultProject.GotProject(response.data?.projects)
        } catch (e: ServerResponseException) {
            ResultProject.ServerError(e.toString())
        } catch (e: ClientRequestException) {
            ResultProject.RequestError()
        } catch (e: Exception) {
            ResultProject.UnknownError()
        }
    }
}