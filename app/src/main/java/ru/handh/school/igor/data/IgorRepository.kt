package ru.handh.school.igor.data

import ru.handh.school.igor.domain.model.PostSignInRequest

interface IgorRepository
{
    suspend fun signIn(emailRequest: PostSignInRequest): String

    suspend fun getSession(refreshToken:String, lifeTime: Int)

    suspend fun signOut()

    suspend fun getProfile()

    suspend fun getProjects()

    suspend fun getNotification()
}