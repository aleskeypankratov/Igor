package ru.handh.school.igor.ui.screen.signin

import android.util.Patterns
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.handh.school.igor.domain.usecase.GetSessionUseCase
import ru.handh.school.igor.domain.usecase.Result
import ru.handh.school.igor.domain.usecase.SignInUseCase
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
            if (!isPasswordGot && validEmail(email)) {
                reduceState { it.copy(signInLoading = true) }
                val signInResult = signInUseCase.signIn(email)
                reduceState { it.copy(result = signInResult, signInLoading = false) }
                if (signInResult is Result.LoggedIn) {
                    isPasswordGot = true
                }
            } else {
                val code = state.value.code
                val getSession = getSessionUseCase.getSession(code)
                if (getSession is Result.GotSession) {
                    reduceState { it.copy(result = getSession) }
                }
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

    private fun validEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    fun validCode(code: String): Boolean {
        val regex = "^\\d{6}\$".toRegex()
        return regex.matches(code)
    }
}
