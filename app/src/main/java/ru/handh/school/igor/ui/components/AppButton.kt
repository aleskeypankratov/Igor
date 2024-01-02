package ru.handh.school.igor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.ui.theme.AppTheme

private val DefaultContainerHeight = 56.dp
private val DefaultProgressIndicatorSize = 18.dp
private val DefaultProgressIndicatorStrokeWidth = 2.dp
private const val alpha = 0.5f


@Composable
fun AppButton(
    label: String,
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    onClick: () -> Unit = {},
    enabled: Boolean = true
) {
    val buttonModifier = modifier
        .then(if (enabled) Modifier.clickable { onClick() } else Modifier.alpha(alpha))
        .clip(AppTheme.roundings.large)
        .background(AppTheme.colors.primary)
        .height(DefaultContainerHeight)
        .padding(horizontal = AppTheme.offsets.medium)

    val textStyle = AppTheme.textStyles.smallMediumText.copy(color = AppTheme.colors.textOnControl)

    Box(
        modifier = buttonModifier, contentAlignment = Alignment.Center
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(DefaultProgressIndicatorSize),
                color = AppTheme.colors.textOnControl,
                strokeWidth = DefaultProgressIndicatorStrokeWidth
            )
        } else {
            BasicText(
                text = label, style = textStyle, maxLines = 1, overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview("На всю ширину")
@Composable
private fun Preview1() {
    AppButton(
        modifier = Modifier.fillMaxWidth(), label = "Foobar"
    )
}

@Preview("Минимальная ширина")
@Composable
private fun Preview2() {
    AppButton(
        label = "Foobar"
    )
}

@Preview("Ограниченная ширина, текст обрезается")
@Composable
private fun Preview3() {
    AppButton(
        modifier = Modifier.width(200.dp),
        label = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
    )
}

@Preview("disable")
@Composable
private fun Preview4() {
    AppButton(
        label = "Foobar", enabled = false
    )
}
