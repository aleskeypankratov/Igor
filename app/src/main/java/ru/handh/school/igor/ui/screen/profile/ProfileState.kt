package ru.handh.school.igor.ui.screen.profile

import ru.handh.school.igor.domain.model.db.ProfileInfo
import ru.handh.school.igor.domain.usecase.result.ResultProfile

val InitialProfileState = ProfileState(
    result = ResultProfile.Default,
    profile = ProfileInfo(name = "", surname = "")
)

data class ProfileState(
    val result: ResultProfile,
    var profile: ProfileInfo
)
