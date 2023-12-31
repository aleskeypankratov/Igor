package ru.handh.school.igor.ui.screen.project

sealed interface ProjectViewAction {
    data object ProjectClicked : ProjectViewAction
}