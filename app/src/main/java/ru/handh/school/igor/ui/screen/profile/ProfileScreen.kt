package ru.handh.school.igor.ui.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.theme.AppTheme

private var DefaultContainerHeight = 56.dp
private var fontSize = 100.sp


@Preview
@Composable
fun ProfileScreen(
    onAction: (ProfileAction) -> Unit = {},
) {
    Column(modifier = Modifier.padding((AppTheme.offsets.medium))) {
        Text(
            text = "Profile", fontSize = fontSize, modifier = Modifier.weight(1f)
        )
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = AppTheme.offsets.large)
            .height(DefaultContainerHeight),
            content = { Text(text = stringResource(R.string.out)) },
            shape = (AppTheme.roundings.large),
            onClick = { onAction(ProfileAction.SubmitClicked) })
    }
}