package ru.handh.school.igor.ui.screen.project

import ru.handh.school.igor.domain.usecase.result.ResultProject

val InitialProjectState = ProjectState(
    result = ResultProject.Default()
)

data class ProjectState(
    val result: ResultProject<Unit>
)
