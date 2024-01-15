package ru.handh.school.igor.ui.screen.project

sealed interface ProjectViewAction {
    data object GetProject : ProjectViewAction
    data class GetDetailProject(val string: String) : ProjectViewAction
}