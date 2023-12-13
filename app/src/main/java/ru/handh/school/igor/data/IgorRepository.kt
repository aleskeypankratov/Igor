package ru.handh.school.igor.data

import io.ktor.client.statement.HttpResponse
import ru.handh.school.igor.domain.model.PostSignInRequest
import ru.handh.school.igor.domain.usecase.Result

interface IgorRepository {
    suspend fun signIn(uuid: String, emailRequest: PostSignInRequest): HttpResponse

    suspend fun getSession(refreshToken: String, lifeTime: Int)

    suspend fun signOut()

    suspend fun getProfile()

    suspend fun getProjects()

    suspend fun getNotification()
}