package ru.handh.school.igor.ui.screen.project

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.GetProjectUseCase
import ru.handh.school.igor.domain.usecase.result.ResultProject
import ru.handh.school.igor.ui.base.BaseViewModel

class ProjectViewModel(
    private val getProjectUseCase: GetProjectUseCase
) : BaseViewModel<ProjectState, ProjectViewAction>(InitialProjectState) {

    override fun onAction(action: ProjectViewAction) = when (action) {
        is ProjectViewAction.ProjectClicked -> onProjectClicked()
    }

    private fun onProjectClicked() {
        viewModelScope.launch {
            reduceState { it.copy(result = ResultProject.Loading()) }
            val response = getProjectUseCase.getProject()
            val projectsList = response.data

            reduceState { it.copy(result = response, projects = emptyMap()) }
        }
    }
}