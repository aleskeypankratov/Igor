package ru.handh.school.igor.ui.screen.project

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.GetProjectUseCase
import ru.handh.school.igor.domain.usecase.result.ResultProject
import ru.handh.school.igor.ui.base.BaseViewModel

class ProjectViewModel(
    private val getProjectUseCase: GetProjectUseCase,
) : BaseViewModel<ProjectState, ProjectViewAction>(InitialProjectState) {

    override fun onAction(action: ProjectViewAction) = when (action) {
        is ProjectViewAction.GetProject -> onGetProject()
        ProjectViewAction.GetDetailProject -> onProjectClicked()
    }

    private fun onGetProject() {
        viewModelScope.launch {
            reduceState { it.copy(result = ResultProject.Loading()) }
            when (val response = getProjectUseCase.getProject()) {
                is ResultProject.GotProject -> reduceState {
                    it.copy(
                        projects = response.data?.data?.projects,
                        result = response
                    )
                }
                else -> reduceState { it.copy(result = response) }
            }
        }
    }

    private fun onProjectClicked() {
        viewModelScope.launch {

        }
    }

}