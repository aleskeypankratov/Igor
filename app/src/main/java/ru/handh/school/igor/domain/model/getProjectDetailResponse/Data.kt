import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val hasMore: Boolean?,
    val projects: Project?
)