package ru.handh.school.igor.ui.screen.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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


@Composable
fun SingleTask(
    name: String, priority: String
) {
    val color: Color = when (priority) {
        "1" -> Color.Red
        "2" -> Color.Yellow
        "3" -> Color.Green
        else -> {
            Color.Black
        }
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .clip(CircleShape)
                .background(color = color)
        )
        Text(
            text = name,
            style = AppTheme.textStyles.mediumRegularText,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun PreviewSingleTask() {
    SingleTask("Создать проект", "1")
}