package ru.handh.school.igor.ui.screen.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.ui.theme.AppTheme
import kotlin.random.Random


@Composable
fun SingleProject(
    name: String, text: String, modifier: Modifier
) {
    val firstLetter = name.firstOrNull()?.uppercase().toString()

    Row(verticalAlignment = Alignment.Top, modifier = modifier.fillMaxWidth()) {
        Box(modifier = Modifier.padding(end = 16.dp)) {
            iconProject(firstLetter, modifier = Modifier.size(40.dp))
        }
        Column {
            Text(
                text = name,
                style = AppTheme.textStyles.mediumRegularText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = AppTheme.colors.projectName

            )
            Text(
                text = text,
                style = AppTheme.textStyles.smallRegularText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = AppTheme.colors.projectDescription
            )
        }
    }
}

fun generateRandomColor(): Color {
    return Color(
        Random.nextFloat(),
        Random.nextFloat(),
        Random.nextFloat(),
    )
}

@Composable
fun iconProject(
    letter: String, modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape)
            .background(color = generateRandomColor())
    ) {
        Text(
            text = letter, style = AppTheme.textStyles.normalMediumText
        )
    }
}


@Preview
@Composable
fun Preview() {
    SingleProject(
        modifier = Modifier,
        name = "Проект 1",
        text = "Давно выяснено, что при оценке дизайна и композиции читаемый текст мешает сосредоточиться. Lorem Ipsum используют потому, что тот обеспечивает."
    )
}