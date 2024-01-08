package ru.handh.school.igor.ui.screen.project

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.GetProfileUseCase
import ru.handh.school.igor.domain.usecase.GetProjectUseCase
import ru.handh.school.igor.domain.usecase.result.ResultProject
import ru.handh.school.igor.ui.base.BaseViewModel

class ProjectViewModel(
    private val getProjectUseCase: GetProjectUseCase,
    private val getProfileUseCase: GetProfileUseCase,

) : BaseViewModel<ProjectState, ProjectViewAction>(InitialProjectState) {

    override fun onAction(action: ProjectViewAction) = when (action) {
        is ProjectViewAction.ProjectClicked -> onProjectClicked()
        is ProjectViewAction.GetProfile -> onProfileRequest()
    }
    private fun onProjectClicked() {
        viewModelScope.launch {
            reduceState { it.copy(result = ResultProject.Loading()) }
            val response = getProjectUseCase.getProject()
            reduceState { it.copy() }
        }
    }

    private fun onProfileRequest() {
        viewModelScope.launch {
            val response = getProfileUseCase.getProfile()
        }
    }
}