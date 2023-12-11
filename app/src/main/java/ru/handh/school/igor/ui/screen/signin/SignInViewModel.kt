package ru.handh.school.igor.ui.screen.signin

import ru.handh.school.igor.ui.base.BaseViewModel

class SignInViewModel : BaseViewModel<SignInState, SignInViewAction>(InitialSignInState) {

    override fun onAction(action: SignInViewAction) =
        when (action) {
            is SignInViewAction.SubmitClicked -> onSubmitClicked()
            is SignInViewAction.UpdateEmail -> onUpdateEmail(action.email)
        }
    private fun onSubmitClicked() = reduceState {
        it.copy(signInLoading = !it.signInLoading)
    }
    private fun onUpdateEmail(email: String) = reduceState {
        it.copy(email = email)
    }
}
