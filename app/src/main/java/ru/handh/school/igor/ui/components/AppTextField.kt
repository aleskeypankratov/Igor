package ru.handh.school.igor.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.ui.theme.AppTheme

private val DefaultContainerHeight = 56.dp
private val DefaultBorderWidth = 1.dp

@Composable

fun AppTextField(
    modifier: Modifier = Modifier,
    hint: String = "",
    value: String,
    onValueChange: (String) -> Unit,
) {
    var isFocused by remember { mutableStateOf(false) }

    Box(modifier = modifier
        .height(DefaultContainerHeight)
        .onFocusChanged { focusState ->
            isFocused = focusState.isFocused
        }
        .border(
            width = DefaultBorderWidth, color = if (isFocused) {
                AppTheme.colors.primary
            } else {
                AppTheme.colors.unfocus
            }, shape = AppTheme.roundings.large
        ), contentAlignment = Alignment.CenterStart) {

        BasicTextField(
            modifier = modifier.padding(horizontal = AppTheme.offsets.medium),
            value = value,
            onValueChange = onValueChange,
            textStyle = AppTheme.textStyles.mediumMediumText.copy(
                if (isFocused) {
                    AppTheme.colors.primaryBrand
                } else {
                    AppTheme.colors.unfocus
                }
            ),
            maxLines = 1
        )

        BasicText(
            modifier = Modifier
                .padding(horizontal = AppTheme.offsets.medium)
                .alpha(if (value.isEmpty()) 1f else 0f),
            text = hint,
            style = AppTheme.textStyles.mediumMediumText.copy(color = AppTheme.colors.unfocus),
            maxLines = 1
        )
    }
}

@Preview("На всю ширину")
@Composable
private fun Preview1() {
    AppTextField(
        hint = "1333333333333333333333",
        onValueChange = { s: String -> s },
        value = "2122222215555555555555552123"
    )
}

@Preview("Минимальная ширина")
@Composable
private fun Preview2() {
    AppTextField(
        modifier = Modifier, hint = "1", onValueChange = { s: String -> s }, value = ""
    )
}