package ru.handh.school.igor.ui.screen.project

import ru.handh.school.igor.domain.usecase.result.ResultProfile

val InitialProfileState = ProjectState(
    result = ResultProfile.Default()
)

data class ProjectState(
    val result: ResultProfile<Unit>
)
