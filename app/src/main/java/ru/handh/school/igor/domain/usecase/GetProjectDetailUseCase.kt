package ru.handh.school.igor.domain.usecase

import GetProjectDetailResponse
import io.ktor.client.plugins.ServerResponseException
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.usecase.result.ResultProject

class GetProjectDetailUseCase(
    private val repository: IgorRepositoryImp
) {
    suspend fun getProjectDetail(): ResultProject<GetProjectDetailResponse> {
        return try {
            val response = repository.getProjectDetail(1)
            ResultProject.GotProjectDetail(response)
        } catch (e: ServerResponseException) {
            ResultProject.UnknownError()
        } catch (e: Exception) {
            ResultProject.UnknownError()
        }
    }
}