package ru.handh.school.igor.ui.screen.about

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.handh.school.igor.R
import ru.handh.school.igor.ui.theme.AppTheme
import ru.handh.school.igor.utils.versionCode
import ru.handh.school.igor.utils.versionName

private val iconSize = 82.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    navController: NavHostController, context: Context
) {

    val version = context.versionName
    val build = context.versionCode
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            title = {
                Text(
                    text = stringResource(R.string.about),
                    style = AppTheme.textStyles.titleText,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = AppTheme.offsets.big)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            },
        )
    }) { containerPadding ->
        Column(
            modifier = Modifier
                .padding(containerPadding)
                .fillMaxSize()
                .background(AppTheme.colors.background)
        ) {
            Row(modifier = Modifier.padding(AppTheme.offsets.medium)) {
                Image(
                    modifier = Modifier.size(iconSize),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier.padding(
                        AppTheme.offsets.medium, AppTheme.offsets.tiny
                    )
                ) {
                    Text(
                        text = stringResource(R.string.name),
                        style = AppTheme.textStyles.smallMediumText,
                        modifier = Modifier.padding(bottom = AppTheme.offsets.tiny)
                    )
                    Text(
                        text = (stringResource(R.string.version, version)),
                        style = AppTheme.textStyles.smallLightText
                    )
                    Text(
                        text = (stringResource(R.string.build, build)),
                        style = AppTheme.textStyles.smallLightText
                    )
                }
            }
        }
    }
}