package ru.handh.school.igor.data


import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
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
import ru.handh.school.igor.domain.model.PostRefreshRequest
import ru.handh.school.igor.domain.model.PostSignInRequest
import ru.handh.school.igor.domain.model.getProfileResponse.GetProfileResponse
import ru.handh.school.igor.domain.model.getProjectsResponse.GetProjectsResponse
import ru.handh.school.igor.domain.model.getSessionResponse.GetSessionResponse

class IgorRepositoryImp(
    private val keyValueStorage: KeyValueStorage
) : IgorRepository {

    private val client = HttpClient(OkHttp) {
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
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        keyValueStorage.accessToken ?: "", keyValueStorage.refreshToken ?: ""
                    )
                }
                refreshTokens {
                    val token = client.post(ApiRoutes.REFRESH) {
                        markAsRefreshTokenRequest()
                        setBody(PostRefreshRequest(keyValueStorage.refreshToken))
                    }.body<GetSessionResponse>()
                    BearerTokens(
                        refreshToken = token.data?.session?.refreshToken ?: "",
                        accessToken = token.data?.session?.accessToken ?: "",
                    )
                }
            }
        }
    }

    override suspend fun signIn(
        id: String, emailRequest: PostSignInRequest
    ): HttpResponse {
        return client.post(ApiRoutes.SIGNIN) {
            attributes.put(Auth.AuthCircuitBreaker, Unit)
            headers {
                append("X-Device-Id", id)
            }
            setBody(emailRequest)
        }
    }

    override suspend fun getSession(
        id: String, incomingCode: String, lifeTime: Int
    ): GetSessionResponse {
        return client.get(ApiRoutes.SESSION) {
            attributes.put(Auth.AuthCircuitBreaker, Unit)
            headers {
                append("X-Device-Id", id)
                append("X-OTP", incomingCode)
            }
        }.body<GetSessionResponse>()
    }

    override suspend fun signOut() {
        client.post(ApiRoutes.SIGNOUT) { attributes.put(Auth.AuthCircuitBreaker, Unit) }
    }

    override suspend fun getProfile(): GetProfileResponse {
        return client.get(ApiRoutes.PROFILE) { attributes.put(Auth.AuthCircuitBreaker, Unit) }
            .body<GetProfileResponse>()
    }

    override suspend fun getProjects(): GetProjectsResponse {
        return client.get(ApiRoutes.PROJECTS) { attributes.put(Auth.AuthCircuitBreaker, Unit) }
            .body<GetProjectsResponse>()
    }

    override suspend fun getNotification() {
        TODO("Not yet implemented")
    }
}