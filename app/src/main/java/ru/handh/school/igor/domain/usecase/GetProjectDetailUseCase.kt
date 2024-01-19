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
            ResultProject.GotProjectDetail(requireNotNull(response.data?.project))
        } catch (e: ServerResponseException) {
            ResultProject.ServerError(e.message)
        } catch (e: Exception) {
            ResultProject.UnknownError("Что-то не работает")
        }
    }
}