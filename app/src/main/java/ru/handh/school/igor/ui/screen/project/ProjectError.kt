package ru.handh.school.igor.ui.screen.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.theme.AppTheme

val defaultHeight = 56.dp
val smallHeight = 24.dp

@Composable
fun ProjectError(error: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(AppTheme.offsets.medium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.error),
            style = AppTheme.textStyles.projectErrorTitle
        )
        Spacer(modifier = Modifier.height(smallHeight))
        Text(text = error, style = AppTheme.textStyles.projectErrorText)
        Spacer(modifier = Modifier.height(defaultHeight))
        Button(modifier = Modifier
            .fillMaxWidth()
            .height(defaultHeight),
            content = { Text(text = stringResource(R.string.repeat)) },
            colors = ButtonDefaults.buttonColors(AppTheme.colors.button),
            shape = (AppTheme.roundings.large),
            onClick = {})
    }
}

@Preview
@Composable
fun PreviewProjectError() {
    ProjectError("Произошла ошибка")
}