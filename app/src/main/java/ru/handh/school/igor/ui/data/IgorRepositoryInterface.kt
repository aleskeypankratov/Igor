package ru.handh.school.igor.ui.data

interface IgorRepositoryInterface
{
    suspend fun signIn(email: String)

    suspend fun getSession(refreshToken:String, lifeTime: Int)

    suspend fun signOut()

    suspend fun getProfile()

    suspend fun getProjects()

    suspend fun getNotification()
}