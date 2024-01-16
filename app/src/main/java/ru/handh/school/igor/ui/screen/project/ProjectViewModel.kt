package ru.handh.school.igor.ui.screen.project

import Project
import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.GetProjectDetailUseCase
import ru.handh.school.igor.domain.usecase.GetProjectUseCase
import ru.handh.school.igor.domain.usecase.result.ResultProject
import ru.handh.school.igor.ui.base.BaseViewModel
import ru.handh.school.igor.ui.navigation.NavigationItem

class ProjectViewModel(
    private val getProjectUseCase: GetProjectUseCase,
    private val getProjectDetailUseCase: GetProjectDetailUseCase,
) : BaseViewModel<ProjectState, ProjectViewAction>(InitialProjectState) {

    override fun onAction(action: ProjectViewAction) = when (action) {
        is ProjectViewAction.GetProject -> onGetProject()
        is ProjectViewAction.GetDetailProject -> onProjectClicked(action.string)
    }

    private fun onGetProject() {
        viewModelScope.launch {
            reduceState { it.copy(result = ResultProject.Loading) }
            when (val response = getProjectUseCase.getProject()) {
                is ResultProject.GotProject -> reduceState {
                    it.copy(
                        projects = response.getProjectsResponse.data?.projects!!,
                        result = response
                    )
                }

                else -> reduceState { it.copy(result = response) }
            }
        }
    }

    private fun onProjectClicked(id: String) {
        viewModelScope.launch {
            Log.v("vm project","request id $id")
            when (val response = getProjectDetailUseCase.getProjectDetail(id)) {
                is ResultProject.GotProjectDetail -> reduceState {
                    it.copy(
                        detailProject = response.getProjectDetailResponse
                    )
                }

                else -> {
                    reduceState {
                        it.copy(
                            detailProject = Project("Error", "Error", "11")
                        )

                    }
                }
            }
            Log.v("detail",state.value.detailProject.toString())
        }
    }
}