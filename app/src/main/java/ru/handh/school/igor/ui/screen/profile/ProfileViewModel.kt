package ru.handh.school.igor.ui.screen.profile

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.SignOutUseCase
import ru.handh.school.igor.ui.base.BaseViewModel

class ProfileViewModel(
    private val signOutUseCase: SignOutUseCase
) : BaseViewModel<ProfileState, ProfileAction>(InitialProfileState) {
    override fun onAction(action: ProfileAction) = when (action) {
        is ProfileAction.SubmitClicked -> onSubmitClicked()
    }

    private fun onSubmitClicked() {
        viewModelScope.launch {
            signOutUseCase.signOut()
        }
    }

}