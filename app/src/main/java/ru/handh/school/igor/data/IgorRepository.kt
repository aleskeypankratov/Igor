package ru.handh.school.igor.data

import io.ktor.client.statement.HttpResponse
import ru.handh.school.igor.domain.model.PostSignInRequest
import ru.handh.school.igor.domain.model.getSessionResponse.GetSessionResponse

interface IgorRepository {

    suspend fun signIn(uuid: String, emailRequest: PostSignInRequest): HttpResponse
    suspend fun getSession(uuid: String, incomingCode: String, lifeTime: Int): GetSessionResponse
    suspend fun refresh()
    suspend fun signOut()
    suspend fun getProfile()
    suspend fun getProjects()
    suspend fun getNotification()
}