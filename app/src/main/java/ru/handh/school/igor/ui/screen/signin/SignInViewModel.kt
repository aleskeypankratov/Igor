package ru.handh.school.igor.ui.screen.signin

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.SignInUseCase
import ru.handh.school.igor.ui.base.BaseViewModel

class SignInViewModel() :
    BaseViewModel<SignInState, SignInViewAction>(InitialSignInState) {
    override fun onAction(action: SignInViewAction) =
        when (action) {
            SignInViewAction.SubmitClicked -> onSubmitClicked()
            is SignInViewAction.UpdateEmail -> onUpdateEmail(action.email)
        }
    private fun onSubmitClicked() {
        val signInUseCase = SignInUseCase()
        viewModelScope.launch {
            reduceState { it.copy(signInLoading = true) }
            val signInResult = signInUseCase.signIn(state.value.email)
            if (signInResult) {
                //Log.d(this.toString(), signInResult.toString())
            }
            reduceState { it.copy(signInLoading = false) }
        }
    }

    private fun onUpdateEmail(email: String) {
        reduceState {
            it.copy(email = email)
        }
    }
}
