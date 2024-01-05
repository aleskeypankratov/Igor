package ru.handh.school.igor.data

import io.ktor.client.statement.HttpResponse
import ru.handh.school.igor.domain.model.PostSignInRequest
import ru.handh.school.igor.domain.model.getProfileResponse.GetProfileResponse
import ru.handh.school.igor.domain.model.getProjectsResponse.GetProjectsResponse
import ru.handh.school.igor.domain.model.getSessionResponse.GetSessionResponse

interface IgorRepository {

    suspend fun signIn(id: String, emailRequest: PostSignInRequest): HttpResponse
    suspend fun getSession(id: String, incomingCode: String, lifeTime: Int): GetSessionResponse
    suspend fun signOut()
    suspend fun getProfile(): GetProfileResponse
    suspend fun getProjects(): GetProjectsResponse
    suspend fun getNotification()
}