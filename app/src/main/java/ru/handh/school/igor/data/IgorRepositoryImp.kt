package ru.handh.school.igor.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.handh.school.igor.domain.model.PostSignInRequest
import ru.handh.school.igor.domain.model.getSessionResponse.GetSessionResponse

class IgorRepositoryImp(
    private val keyValueStorage: KeyValueStorage
) : IgorRepository {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                encodeDefaults = false
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("Logger Ktor =>", message)
                }
            }
            level = LogLevel.ALL
        }
        expectSuccess = true
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }

    override suspend fun signIn(uuid: String, emailRequest: PostSignInRequest): HttpResponse {
        return client.post(ApiRoutes.SIGNIN) {
            headers {
                append("X-Device-Id", uuid)
            }
            setBody(emailRequest)
        }
    }

    override suspend fun getSession(
        uuid: String,
        incomingCode: String,
        lifeTime: Int
    ): GetSessionResponse {
        return client.get(ApiRoutes.SESSION) {
            headers {
                append("X-Device-Id", uuid)
                append("X-OTP", incomingCode)
            }
        }.body<GetSessionResponse>()
    }

    override suspend fun refresh() {
        client.post(ApiRoutes.REFRESH) {
        }
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