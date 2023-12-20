package ru.handh.school.igor.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.theme.AppTheme

private val DefaultContainerHeight = 56.dp
private val version = 1.13
private val build = 42
private val iconSize = 82.dp
private val bottomPadding = 40.dp
private val weightOfBox = 1f

@Composable
fun AboutContent(navController: NavHostController) {
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.offsets.large),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.about),
            style = AppTheme.textStyles.normalMediumText
        )
        Spacer(modifier = Modifier.height(AppTheme.offsets.medium))
        Box(
            modifier = Modifier
                .background(AppTheme.colors.background)
                .padding(AppTheme.offsets.medium)
                .fillMaxWidth()
                .weight(weightOfBox)
        ) {
            Row {
                Image(
                    modifier = Modifier.size(iconSize),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null
                )
                Column {
                    Text(
                        text = stringResource(R.string.name),
                        style = AppTheme.textStyles.mediumMediumText,
                        modifier = Modifier.padding(AppTheme.offsets.medium, AppTheme.offsets.tiny)
                    )
                    Text(
                        text = stringResource(R.string.version, version),
                        style = AppTheme.textStyles.smallLightText,
                        modifier = Modifier.padding(horizontal = AppTheme.offsets.medium)
                    )
                    Text(
                        text = stringResource(R.string.build, build),
                        style = AppTheme.textStyles.smallLightText,
                        modifier = Modifier.padding(horizontal = AppTheme.offsets.medium)
                    )
                }
            }
        }
        Box(
            Modifier
                .background(AppTheme.colors.background)
                .padding(AppTheme.offsets.medium)
                .align(Alignment.End)
                .padding(bottom = bottomPadding)
        ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(DefaultContainerHeight),
                content = { Text(text = stringResource(R.string.out)) },
                shape = (AppTheme.roundings.large),
                colors = ButtonDefaults.buttonColors(AppTheme.colors.button),
                onClick = { navController.popBackStack() })
        }
    }
}

@Preview
@Composable
fun Preview() {
}