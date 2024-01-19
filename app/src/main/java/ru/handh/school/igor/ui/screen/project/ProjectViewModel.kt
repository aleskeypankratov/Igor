package ru.handh.school.igor.ui.screen.project

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.GetProjectDetailUseCase
import ru.handh.school.igor.domain.usecase.GetProjectUseCase
import ru.handh.school.igor.domain.usecase.result.ResultProject
import ru.handh.school.igor.ui.base.BaseViewModel

class ProjectViewModel(
    private val getProjectUseCase: GetProjectUseCase,
    private val getProjectDetailUseCase: GetProjectDetailUseCase,
) : BaseViewModel<ProjectState, ProjectViewAction>(InitialProjectState) {

    private val _stateId = MutableStateFlow("")
    val stateId = _stateId.asStateFlow()

    fun setId(newId: String) {
        _stateId.value = newId
    }

    override fun onAction(action: ProjectViewAction) = when (action) {
        is ProjectViewAction.GetProject -> onGetProject()
        is ProjectViewAction.GetDetailProject -> {
            onProjectClicked(action.string)
        }
    }

    private fun onGetProject() {
        viewModelScope.launch {
            reduceState { it.copy(result = ResultProject.Loading) }
            when (val response = getProjectUseCase.getProject()) {
                is ResultProject.GotProject -> reduceState {
                    it.copy(
                        projects = requireNotNull(response.getProjectsResponse.data?.projects),
                        result = response
                    )
                }

                else -> reduceState { it.copy(result = response) }
            }
        }
    }

    private fun onProjectClicked(id: String) {
        viewModelScope.launch {
            when (val response = getProjectDetailUseCase.getProjectDetail(id)) {
                is ResultProject.GotProjectDetail -> reduceState {
                    it.copy(detailProject = response.getProjectDetailResponse)
                }

                else -> {}
            }
        }
    }
}