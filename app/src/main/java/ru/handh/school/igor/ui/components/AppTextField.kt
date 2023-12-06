package ru.handh.school.igor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.ui.theme.AppTheme

private val DefaultContainerHeight = 56.dp

@Composable
fun AppTextField(
    hint: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .border(1.dp, AppTheme.colors.borderUnfocus, AppTheme.roundings.large)
            .height(DefaultContainerHeight)
            .focusable()
            .padding(horizontal = AppTheme.offsets.medium),
        contentAlignment = Alignment.CenterStart

    ) {
        BasicText(text = hint, style = AppTheme.textStyles.text1)
        BasicTextField(value = "", { s: String -> })
    }
}


@Preview("")
@Composable
private fun Preview() {
    AppTextField("Текст")
}
