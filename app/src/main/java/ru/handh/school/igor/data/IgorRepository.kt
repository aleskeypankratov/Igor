package ru.handh.school.igor.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.handh.school.igor.domain.model.PostSignInRequest

class IgorRepository: IgorRepositoryInterface {

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            level = LogLevel.ALL
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }

    override suspend fun signIn(emailRequest: PostSignInRequest): String {

        return try {
            client.post(ApiRoutes.SIGNIN) {
                emailRequest
            }.toString()
        }
            catch (e: Exception) {
                "Error"
            }
    }

    override suspend fun getSession(refreshToken: String, lifeTime: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun signOut() {
        TODO("Not yet implemented")
    }

    override suspend fun getProfile() {
        TODO("Not yet implemented")
    }

    override suspend fun getProjects() {
        TODO("Not yet implemented")
    }

    override suspend fun getNotification() {
        TODO("Not yet implemented")
    }
}