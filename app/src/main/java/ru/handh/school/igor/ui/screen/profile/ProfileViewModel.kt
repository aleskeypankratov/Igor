package ru.handh.school.igor.ui.screen.profile

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.handh.school.igor.ui.base.BaseViewModel

class ProfileViewModel : BaseViewModel<ProfileState, ProfileAction>(InitialProfileState) {
    override fun onAction(action: ProfileAction) = when (action) {
        is ProfileAction.SubmitClicked -> onSubmitClicked()
    }

    private fun onSubmitClicked() {
        viewModelScope.launch {

        }
    }

}