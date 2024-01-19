package ru.handh.school.igor.domain.usecase.result

import Project
import ru.handh.school.igor.domain.model.getProjectsResponse.GetProjectsResponse

sealed interface ResultProject {
    data class GotProject(val getProjectsResponse: GetProjectsResponse) : ResultProject
    data class GotProjectDetail(val getProjectDetailResponse: Project) :
        ResultProject

    data class UnknownError(val error: String) : ResultProject
    data object Loading : ResultProject
    data class ServerError(val error: String) : ResultProject
    data object Default : ResultProject

}