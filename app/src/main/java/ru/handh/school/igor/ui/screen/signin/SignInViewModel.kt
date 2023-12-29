package ru.handh.school.igor.ui.screen.signin

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.GetSessionUseCase
import ru.handh.school.igor.domain.usecase.SignInUseCase
import ru.handh.school.igor.domain.usecase.result.ResultSignIn
import ru.handh.school.igor.ui.base.BaseViewModel

//
class SignInViewModel(
    private val signInUseCase: SignInUseCase,
    private val getSessionUseCase: GetSessionUseCase
) : BaseViewModel<SignInState, SignInViewAction>(InitialSignInState) {
    private var isPasswordGot = false

    override fun onAction(action: SignInViewAction) = when (action) {
        is SignInViewAction.SubmitClicked -> onSubmitClicked()
        is SignInViewAction.UpdateEmail -> onUpdateEmail(action.email)
        is SignInViewAction.AddCode -> onAddCode(action.code)
    }

    private fun onSubmitClicked() {
        viewModelScope.launch {
            val email = state.value.email
            if (!isPasswordGot) {

                reduceState { it.copy(result = ResultSignIn.LoggedIn(), signInLoading = false) }
                isPasswordGot = true

/*                reduceState { it.copy(signInLoading = true) }
                val signInResult = signInUseCase.signIn(email)
                reduceState { it.copy(result = signInResult, signInLoading = false) }
                if (signInResult is ResultSignIn.LoggedIn) {
                    isPasswordGot = true
                }*/
            } else {
                reduceState { it.copy(result = ResultSignIn.GotSession())}

/*                val code = state.value.code
                val getSession = getSessionUseCase.getSession(code)
                if (getSession is ResultSignIn.GotSession) {
                    reduceState { it.copy(result = getSession) }
                }*/
            }
        }
    }

    private fun onUpdateEmail(email: String) {
        reduceState {
            it.copy(email = email)
        }
    }

    private fun onAddCode(code: String) {
        reduceState {
            it.copy(code = code)
        }
    }

}
