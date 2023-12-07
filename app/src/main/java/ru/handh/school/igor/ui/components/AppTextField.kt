package ru.handh.school.igor.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.ui.theme.AppTheme

private val DefaultContainerHeight = 56.dp

@Composable
fun AppTextField(
    hint: String,
    modifier: Modifier = Modifier
) {
    var mail by remember {
        mutableStateOf("")
    }
    val isFocused = remember { mutableStateOf(true) }

    val borderColor by animateColorAsState(
        targetValue = if (!isFocused.value) AppTheme.colors.unfocus else AppTheme.colors.primary,
        label = "",
    )

    BasicTextField(
        value = mail,
        onValueChange = { newText ->
            mail = newText
        },
        textStyle = AppTheme.textStyles.textHint
            .copy(color = AppTheme.colors.primaryBrand),
        maxLines = 1,
        decorationBox = { innerTextField ->
            Box(
                modifier = modifier
                    .focusable()
                    .onFocusChanged { focusState ->
                        isFocused.value = focusState.isFocused
                    }
                    .border(1.dp, borderColor, AppTheme.roundings.large)
                    .padding(horizontal = AppTheme.offsets.medium)
                    .height(DefaultContainerHeight),
                contentAlignment = Alignment.CenterStart
            ) {
                if (mail.isEmpty() && !isFocused.value) {
                    BasicText(
                        text = hint,
                        modifier = Modifier.fillMaxWidth(),
                        style = AppTheme.textStyles.textHint
                            .copy(color = AppTheme.colors.unfocus),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                innerTextField()
            }
        }
    )
}
@Preview("")
@Composable
private fun Preview() {
    AppTextField("Foobar")
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