import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val name: String?,
    val description: String?,
    val id : String?
)