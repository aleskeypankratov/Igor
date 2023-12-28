package ru.handh.school.igor.data

import io.ktor.client.statement.HttpResponse
import ru.handh.school.igor.domain.model.PostSignInRequest
import ru.handh.school.igor.domain.model.getProfileResponse.getProfileResponse
import ru.handh.school.igor.domain.model.getProjectsResponse.getProjectsResponse
import ru.handh.school.igor.domain.model.getSessionResponse.GetSessionResponse

interface IgorRepository {

    suspend fun signIn(id: String, emailRequest: PostSignInRequest): HttpResponse
    suspend fun getSession(id: String, incomingCode: String, lifeTime: Int): GetSessionResponse
    suspend fun refresh(refreshToken: String)
    suspend fun signOut()
    suspend fun getProfile(): getProfileResponse
    suspend fun getProjects(): getProjectsResponse
    suspend fun getNotification()
}