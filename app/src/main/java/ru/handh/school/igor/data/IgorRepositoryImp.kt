package ru.handh.school.igor.data


import GetProjectDetailResponse
import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerAuthProvider
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.plugin
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
import ru.handh.school.igor.domain.model.db.ProfileDao
import ru.handh.school.igor.domain.model.getProfileResponse.GetProfileResponse
import ru.handh.school.igor.domain.model.getProjectsResponse.GetProjectsResponse
import ru.handh.school.igor.domain.model.getSessionResponse.GetTokenResponse

class IgorRepositoryImp(
    private val keyValueStorage: KeyValueStorage, private val profileDao: ProfileDao
) : IgorRepository {

    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                encodeDefaults = true
                allowStructuredMapKeys = true
                useArrayPolymorphism = true
                allowSpecialFloatingPointValues = true
                useAlternativeNames = true
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
                    val accessToken = keyValueStorage.accessToken ?: ""
                    val refreshToken = keyValueStorage.refreshToken ?: ""
                    BearerTokens(
                        accessToken = accessToken,
                        refreshToken = refreshToken
                    )
                }
                refreshTokens {
                    val token = client.post(ApiRoutes.REFRESH) {
                        markAsRefreshTokenRequest()
                        setBody(PostRefreshRequest(keyValueStorage.refreshToken))
                    }.body<GetTokenResponse>()
                    keyValueStorage.accessToken = requireNotNull(token.data?.session?.accessToken)
                    keyValueStorage.refreshToken = requireNotNull(token.data?.session?.refreshToken)
                    BearerTokens(
                        accessToken = requireNotNull(keyValueStorage.accessToken),
                        refreshToken = requireNotNull(keyValueStorage.refreshToken)
                    )
                }
            }
        }
    }
    private val provider = client.plugin(Auth).providers.filterIsInstance<BearerAuthProvider>()
        .firstOrNull()?.clearToken()

    override suspend fun signIn(
        id: String, emailRequest: PostSignInRequest
    ): HttpResponse {
        provider
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
    ): GetTokenResponse {
        provider
        return client.get(ApiRoutes.SESSION) {
            attributes.put(Auth.AuthCircuitBreaker, Unit)
            headers {
                append("X-Device-Id", id)
                append("X-OTP", incomingCode)
            }
        }.body<GetTokenResponse>()
    }

    override suspend fun signOut() {
        client.post(ApiRoutes.SIGNOUT)
        profileDao.deleteProfile()
    }

    override suspend fun getProfile(): GetProfileResponse {
        //val profileDb = profileDao.getProfile()
        //Log.v("db =>", profileDb.toString())
        //if (profile == null) {
        val response = client.get(ApiRoutes.PROFILE).body<GetProfileResponse>()
//            profileDao.insertProfile(
//                ProfileInfo(
//                    uid = 1,
//                    name = requireNotNull(response.data?.profile?.name),
//                    surname = requireNotNull(response.data?.profile?.surname)
//                )
//            )
        return response
    }
//    else
//             return GetProfileResponse(Data(Profile(name = profile.name, surname = profile.surname)))
//    }

    override suspend fun getProjects(): GetProjectsResponse {
        return client.get(ApiRoutes.PROJECTS).body<GetProjectsResponse>()
    }

    override suspend fun getProjectDetail(id: String): GetProjectDetailResponse {
        return client.get(ApiRoutes.PROJECTDETAIL + id)
            .body<GetProjectDetailResponse>()
    }
}