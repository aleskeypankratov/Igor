package ru.handh.school.igor.domain.usecase.result

import ru.handh.school.igor.domain.model.getProjectsResponse.GetProjectsResponse

sealed class ResultProject<T> {
    data class GotProject(val response: GetProjectsResponse) : ResultProject<GetProjectsResponse>()
    class UnknownError<T> : ResultProject<T>()
    class Loading<T> : ResultProject<T>()
    class ServerError<T> : ResultProject<T>()
    class Default<T> : ResultProject<T>()

}