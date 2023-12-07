package ru.handh.school.igor.ui.domain.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class PostSignIn (
    @SerialName("Email" ) var Email : String? = null
)