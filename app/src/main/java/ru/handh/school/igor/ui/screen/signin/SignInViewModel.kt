package ru.handh.school.igor.ui.screen.signin

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.usecase.GetSessionUseCase
import ru.handh.school.igor.domain.usecase.Result
import ru.handh.school.igor.domain.usecase.SignInUseCase
import ru.handh.school.igor.ui.base.BaseViewModel

class SignInViewModel : BaseViewModel<SignInState, SignInViewAction>(InitialSignInState) {

    private val igorRepository = IgorRepositoryImp()
    private val signInUseCase = SignInUseCase(igorRepository)
    private val getSessionUseCase = GetSessionUseCase(igorRepository)
    private val resultChannel = Channel<Result<Unit>>()
    val logResult = resultChannel.receiveAsFlow()
    private var isPasswordGot = false

    override fun onAction(action: SignInViewAction) = when (action) {
        is SignInViewAction.SubmitClicked -> onSubmitClicked()
        is SignInViewAction.UpdateEmail -> onUpdateEmail(action.email)
        is SignInViewAction.AddCode -> onAddCode(action.code)
    }

    private fun onSubmitClicked() {
        viewModelScope.launch {
            val email = state.value.email
            val code = state.value.code
            if (!isPasswordGot && validEmail(email)) {
                reduceState { it.copy(signInLoading = true) }
                val signInResult = signInUseCase.signIn(email)
                resultChannel.send(signInResult)
                if (signInResult is Result.LoggedIn) {
                    isPasswordGot = true
                }
                reduceState { it.copy(signInLoading = false) }
            } else if (validCode(code)) {
                val getSession = getSessionUseCase.getSession(code)
                if (getSession is Result.GotSession) {
                    resultChannel.send(getSession)
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
}
fun validEmail(email: String): Boolean {
    val regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$".toRegex()
    return regex.matches(email)
}

fun validCode(code: String): Boolean {
    val regex = "^\\d{6}\$".toRegex()
    return regex.matches(code)
}
