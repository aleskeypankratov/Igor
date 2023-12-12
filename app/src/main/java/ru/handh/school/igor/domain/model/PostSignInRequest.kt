package ru.handh.school.igor.domain.model
import kotlinx.serialization.Serializable
@Serializable
data class PostSignInRequest (
    var email : String
)