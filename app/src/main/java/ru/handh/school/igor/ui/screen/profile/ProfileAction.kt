package ru.handh.school.igor.ui.screen.profile

sealed interface ProfileAction {
    data object SubmitClicked : ProfileAction
}