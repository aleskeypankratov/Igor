package ru.handh.school.igor.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.ui.theme.AppTheme

private val DefaultContainerHeight = 56.dp

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    hint: String = ""
) {
    var mailValue by remember { mutableStateOf(TextFieldValue()) }
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }

    Box(modifier = modifier
        .height(DefaultContainerHeight)
        .focusRequester(focusRequester)
        .onFocusChanged { focusState ->
            isFocused = focusState.isFocused
        }
        .border(
            width = 1.dp,
            color = if (isFocused) AppTheme.colors.primary
                    else AppTheme.colors.unfocus,
            shape = AppTheme.roundings.large
        ),
        contentAlignment = Alignment.CenterStart
    ) {

        BasicTextField(
            value = mailValue,
            onValueChange = {
                mailValue = it
            },
            modifier = modifier.padding(horizontal = AppTheme.offsets.medium),
            textStyle = AppTheme.textStyles.textHint
                .copy(
                    if (isFocused) AppTheme.colors.primaryBrand
                    else AppTheme.colors.unfocus
                ),
            maxLines = 1
        )

        if (mailValue.text.isEmpty() && !isFocused) {
            BasicText(
                text = hint,
                modifier = Modifier
                    .padding(horizontal = AppTheme.offsets.medium),
                style = AppTheme.textStyles.textHint
                    .copy(color = AppTheme.colors.unfocus),
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
fun preview() {
    AppTextField(hint = "Tst")
}

@Preview("Ограниченная ширина, текст обрезается")
@Composable
private fun Preview3() {
    AppTextField(
        modifier = Modifier
            .width(200.dp),
        hint = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
    )
}
