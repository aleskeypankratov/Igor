package ru.handh.school.igor.ui.screen.project

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.handh.school.igor.domain.model.getProjectsResponse.Projects
import ru.handh.school.igor.ui.navigation.NavigationItem
import ru.handh.school.igor.ui.theme.AppTheme
import kotlin.random.Random

val defaultIconSize = 40.dp
val defaultMinSizeOfProject = 60.dp

@Composable
fun SingleProject(
    project: Projects,
    navController: NavHostController,
    vm: ProjectViewModel,
    stateId: String
) {
    val name = project.name
    val description = project.description
    val id = project.id
    val firstLetter = name?.get(0)?.uppercase() ?: "P"

    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .padding(AppTheme.offsets.small)
            .defaultMinSize(minHeight = defaultMinSizeOfProject)
            .fillMaxWidth()
            .clickable {
                vm.setId(requireNotNull(id))
                navController.navigate(NavigationItem.ProjectDetail.route)
            }
    ) {
        Box(modifier = Modifier.padding(end = AppTheme.offsets.medium)) {
            IconProject(
                letter = firstLetter,
                modifier = Modifier.size(defaultIconSize)
            )
        }
        Column {
            Text(
                text = name ?: "",
                style = AppTheme.textStyles.mediumRegularText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = AppTheme.colors.projectName
            )
            Text(
                text = description ?: "",
                style = AppTheme.textStyles.smallRegularText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = AppTheme.colors.projectDescription
            )
        }
    }
}

@Composable
fun IconProject(
    letter: String, modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape)
            .background(color = generateRandomColor())
    ) {
        Text(
            text = letter,
            style = AppTheme.textStyles.normalMediumText
        )
    }
}

fun generateRandomColor(): Color {
    return Color(
        Random.nextFloat(),
        Random.nextFloat(),
        Random.nextFloat(),
    )
}
