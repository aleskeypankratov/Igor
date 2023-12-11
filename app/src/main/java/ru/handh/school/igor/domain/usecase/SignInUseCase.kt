package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.PostSignInRequest
import ru.handh.school.igor.ui.screen.signin.SignInState

class SignInUseCase {

    private var igorRepositoryImp: IgorRepositoryImp = IgorRepositoryImp()

    suspend fun getResponse(postSignInRequest: PostSignInRequest) {
        igorRepositoryImp.signIn(postSignInRequest)
    }

}