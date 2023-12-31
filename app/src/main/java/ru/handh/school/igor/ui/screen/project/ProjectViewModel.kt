package ru.handh.school.igor.ui.screen.project

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.GetProjectUseCase
import ru.handh.school.igor.ui.base.BaseViewModel

class ProjectViewModel(
    getProjectUseCase: GetProjectUseCase
) : BaseViewModel<ProjectState, ProjectViewAction>(InitialProfileState) {

    override fun onAction(action: ProjectViewAction) = when (action) {
        is ProjectViewAction.ProjectClicked -> onProjectClicked()
    }

    private fun onProjectClicked() {
        viewModelScope.launch {
            getProjectUseCase.getProject()
        }
    }
}