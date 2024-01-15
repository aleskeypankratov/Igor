package ru.handh.school.igor.domain.usecase

import io.ktor.client.plugins.ServerResponseException
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.usecase.result.ResultProject

class GetProjectDetailUseCase(
    private val repository: IgorRepositoryImp
) {
    suspend fun getProjectDetail(id: String): ResultProject {
        return try {
            val response = repository.getProjectDetail(id)
            ResultProject.GotProjectDetail(response.data?.project!!)
        } catch (e: ServerResponseException) {
            ResultProject.ServerError(e.toString())
        } catch (e: Exception) {
            ResultProject.UnknownError(e.toString())
        }
    }
}