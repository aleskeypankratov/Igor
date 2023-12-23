package ru.handh.school.igor.ui.screen.profile

import ru.handh.school.igor.domain.usecase.result.ResultProfile

val InitialProfileState = ProfileState(
    name = "",
    result = ResultProfile.Default()
)

data class ProfileState(
    val name: String,
    val result: ResultProfile<Unit>
)
