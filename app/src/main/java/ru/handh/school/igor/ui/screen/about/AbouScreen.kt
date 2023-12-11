package ru.handh.school.igor.ui.screen.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.theme.AppTheme

private val DefaultContainerHeight = 56.dp
private val version = 1.13
private val build = 42

@Composable
fun AboutContent() {
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.offsets.medium),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.about),
            style = AppTheme.textStyles.normalText
        )
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .background(AppTheme.colors.background)
                .padding(AppTheme.offsets.medium)
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
        ) {
            Row {
                Icon(
                    modifier = Modifier.size(82.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null
                )
                Column {
                    Text(
                        text = stringResource(R.string.name),
                        style = AppTheme.textStyles.mediumText,
                        modifier = Modifier.padding(AppTheme.offsets.medium, 5.dp)
                    )
                    Text(
                        text = stringResource(R.string.version, version),
                        modifier = Modifier.padding(horizontal = AppTheme.offsets.medium)
                    )
                    Text(
                        text = stringResource(R.string.build, build),
                        modifier = Modifier.padding(horizontal = AppTheme.offsets.medium)
                    )
                }
            }
        }
        Box(
            Modifier
                .background(AppTheme.colors.background)
                .padding(AppTheme.offsets.medium)
        ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(DefaultContainerHeight),
                content = { Text(text = stringResource(R.string.out)) },
                colors = ButtonDefaults.buttonColors(AppTheme.colors.button),
                onClick = { /*TODO*/ })
        }
    }
}

@Preview
@Composable
fun preview() {
    AboutContent()
}