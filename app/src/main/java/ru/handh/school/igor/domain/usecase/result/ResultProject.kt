package ru.handh.school.igor.domain.usecase.result

import Project
import ru.handh.school.igor.domain.model.getProjectsResponse.GetProjectsResponse

/*
sealed class ResultProject<T>(val data: T? = null) {
    class GotProject<T>(data: T) : ResultProject<T>(data)
    class GotProjectDetail<T>(data: T) : ResultProject<T>(data)
    class UnknownError<T> : ResultProject<T>()
    class Loading<T> : ResultProject<T>()
    class ServerError<T> : ResultProject<T>()
    class Default<T> : ResultProject<T>()
}*/
sealed interface ResultProject {
    data class GotProject(val getProjectsResponse: GetProjectsResponse) : ResultProject
    data class GotProjectDetail(val getProjectDetailResponse: Project) :
        ResultProject

    data class UnknownError(val error: String) : ResultProject
    data object Loading : ResultProject
    data class ServerError (val error: String) : ResultProject
    data object Default : ResultProject

}