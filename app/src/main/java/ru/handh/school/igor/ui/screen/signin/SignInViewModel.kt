package ru.handh.school.igor.ui.screen.signin

import androidx.lifecycle.viewModelScope
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.SignInUseCase
import ru.handh.school.igor.ui.base.BaseViewModel

class SignInViewModel(private val signInUseCase: SignInUseCase) :
    BaseViewModel<SignInState, SignInViewAction>(InitialSignInState) {

    override fun onAction(action: SignInViewAction) =
        when (action) {
            is SignInViewAction.SubmitClicked -> onSubmitClicked()
            is SignInViewAction.UpdateEmail -> onUpdateEmail(action.email)
        }

    private fun onSubmitClicked() = reduceState {
        viewModelScope.launch {
            if (signInUseCase.signIn(it.email) == HttpStatusCode.OK) {
                TODO()
            }
        }
        it.copy(signInLoading = !it.signInLoading)
    }

    private fun onUpdateEmail(email: String) = reduceState {
        it.copy(email = email)
    }

}
