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
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpHeaders.XRequestId
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.handh.school.igor.domain.model.PostSignInRequest

class IgorRepositoryImp : IgorRepository {

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                encodeDefaults = false
            })
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
        install(Logging) {
            level = LogLevel.ALL
        }
    }

    override suspend fun signIn(uuid: String, emailRequest: PostSignInRequest): HttpResponse {

        return client.post(ApiRoutes.SIGNIN) {
            header(XRequestId, uuid)
            contentType(ContentType.Application.Json)
            setBody(emailRequest)
            accept(ContentType.Application.Json)
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