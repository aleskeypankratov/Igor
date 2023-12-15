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
            if (!isPasswordGot) {
                reduceState { it.copy(signInLoading = true) }
                val signInResult = signInUseCase.signIn(state.value.email)
                resultChannel.send(signInResult)
                if (signInResult is Result.LoggedIn) {
                    isPasswordGot = true
                }
                reduceState { it.copy(signInLoading = false) }
            } else {
                val getSession = getSessionUseCase.getSession(state.value.code)
                resultChannel.send(getSession)
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
