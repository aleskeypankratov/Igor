package ru.handh.school.igor.data

import io.ktor.client.statement.HttpResponse
import ru.handh.school.igor.domain.model.PostSignInRequest
interface IgorRepository {
    suspend fun signIn(uuid: String, emailRequest: PostSignInRequest): HttpResponse
    suspend fun getSession(uuid: String, incomingCode: String, lifeTime: Int)
    suspend fun refresh()
    suspend fun signOut()
    suspend fun getProfile()
    suspend fun getProjects()
    suspend fun getNotification()
}