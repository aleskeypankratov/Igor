package ru.handh.school.igor.domain.usecase

import ru.handh.school.igor.data.IgorRepositoryImp
import ru.handh.school.igor.domain.model.PostSignInRequest
import java.util.UUID

class RequestUseCase{
    private val repository = IgorRepositoryImp()
    private val uuid: String = UUID.randomUUID().toString()

    suspend fun signIn(email: String): Result<Unit> {
        return try {
            val response =
                repository.signIn(uuid, PostSignInRequest(email))
            Result.LoggedIn()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }

    suspend fun getSession(code: String): Result<Unit> {
        return try {
            val response = repository.getSession(uuid, code, 300_000)
            Result.GetSession()
        } catch (e: Exception) {
            Result.UnknownError()
        }
    }
}