package ru.handh.school.igor.ui.screen.profile

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.GetProfileUseCase
import ru.handh.school.igor.domain.usecase.SignOutUseCase
import ru.handh.school.igor.domain.usecase.result.ResultProfile
import ru.handh.school.igor.ui.base.BaseViewModel

class ProfileViewModel(
    private val signOutUseCase: SignOutUseCase,
    private val getProfileUseCase: GetProfileUseCase
) : BaseViewModel<ProfileState, ProfileViewAction>(InitialProfileState) {
    override fun onAction(action: ProfileViewAction) = when (action) {
        is ProfileViewAction.ExitClicked -> onExitClicked()
        is ProfileViewAction.GetProfile -> onGetProfile()
    }

    private fun onExitClicked() {
        viewModelScope.launch {
            signOutUseCase.signOut()
        }
    }

    private fun onGetProfile() {
        viewModelScope.launch {
            when (val result = getProfileUseCase.getProfile()) {
                is ResultProfile.GotProfile ->
                    reduceState {
                        it.copy(profile = result.data!!)
                }
                else -> {}
            }
        }
    }
}