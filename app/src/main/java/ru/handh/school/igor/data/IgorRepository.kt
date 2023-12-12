package ru.handh.school.igor.data

import io.ktor.http.HttpStatusCode
import ru.handh.school.igor.domain.model.PostSignInRequest

interface IgorRepository {
    suspend fun signIn(uuid: String, emailRequest: PostSignInRequest): HttpStatusCode

    suspend fun getSession(refreshToken: String, lifeTime: Int)

    suspend fun signOut()

    suspend fun getProfile()

    suspend fun getProjects()

    suspend fun getNotification()
}