package ru.handh.school.igor.ui.screen.profile

import ru.handh.school.igor.domain.usecase.result.ResultProfile

val InitialProfileState = ProfileState(
    result = ResultProfile.Default()
)

data class ProfileState(
    val result: ResultProfile<Unit>
)
